package fr.romaindu35.pufferjavaapi.impl;

import fr.romaindu35.pufferjavaapi.api.Authentificator;
import fr.romaindu35.pufferjavaapi.api.CookieManager;
import fr.romaindu35.pufferjavaapi.api.exception.PufferException;
import fr.romaindu35.pufferjavaapi.api.models.PufferSession;
import fr.romaindu35.pufferjavaapi.api.request.Request;
import fr.romaindu35.pufferjavaapi.impl.manager.NodesManager;
import fr.romaindu35.pufferjavaapi.impl.manager.ServersManager;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PufferJavaAPI {

    private final Authentificator authentificator;

    public final Logger logger;

    private final CookieManager cookieManager;
    private final Request request;

    private LocalDateTime sessionExpiration;
    private List<String> userScopes;


    // Manager
    private NodesManager nodesManager;
    private ServersManager serversManager;

    public PufferJavaAPI(Authentificator authentificator) throws PufferException {
        this(authentificator, Level.ALL);
    }

    public PufferJavaAPI(Authentificator authentificator, Level level) throws PufferException {
        this.authentificator = authentificator;

        this.logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        this.logger.setLevel(level);

        this.cookieManager = new CookieManager(null, this.authentificator.getDomain());

        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(this.getCookieManager())
                .addInterceptor(chain -> {
                    okhttp3.Request request = chain.request().newBuilder()
                            .addHeader("Content-Type", "application/json")
                            .addHeader("Accept", "application/json")
                            .build();
                    return chain.proceed(request);
                })
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(this.authentificator.getURI().getScheme() + "://" + this.authentificator.getDomain())
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.request = retrofit.create(Request.class);
        this.authenticate();
        this.setupManager();
    }

    public void authenticate() throws PufferException {
        String domain = this.authentificator.getDomain();

        if (!(domain.equals("127.0.0.1") || domain.equals("localhost")) && !(this.authentificator.getURI().getScheme().equals("https")))
            this.logger.severe("You are using Puffer4J with a remote server in an insecure mode. You are strongly encouraged to use SSL by changing the Puffer4J constructor's useSSL parameter.");

        PufferSession pufferSession = this.send(this.request.getSession(this.authentificator), false);
        this.userScopes = pufferSession.getScopes();
        this.getCookieManager().setSession(pufferSession.getSession());

        // Define the session expiration in order to request a new session when needed.
        this.sessionExpiration = LocalDateTime.now().plusHours(2L);

        this.logger.info("Your are successfully authenticate");
    }

    public void checkRenewToken() throws PufferException {
        if (this.sessionExpiration == null || this.sessionExpiration.compareTo(LocalDateTime.now()) > 0) return;
        this.logger.info("The session has expired. Renewing...");
        this.authenticate();
    }

    public void setupManager() {
        this.nodesManager = new NodesManager(this);
        this.serversManager = new ServersManager(this);
    }

    public CookieManager getCookieManager() {
        return cookieManager;
    }

    public Request getRequest() {
        return request;
    }

    public NodesManager getNodesManager() {
        return nodesManager;
    }

    public ServersManager getServersManager() {
        return serversManager;
    }

    public <T> T send(Call<T> call) throws PufferException {
        return send(call, true);
    }

    public <T> T send(Call<T> call, boolean chekRenew) throws PufferException {
        if (chekRenew)
            checkRenewToken();

        Response<T> session;
        try {
            session = call.execute();
        } catch (IOException e) {
            throw new PufferException("getting session", e);
        }
        return parse(session);
    }

    private <T> T parse(Response<T> response) throws PufferException {
        if (!response.isSuccessful())
            throw new PufferException(response);
        T responseBody = response.body();
        if (responseBody == null && response.code() != 204)
            throw new PufferException(response);
        return responseBody;
    }
}
