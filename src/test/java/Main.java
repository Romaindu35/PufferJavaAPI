import fr.romaindu35.pufferjavaapi.api.Authentificator;
import fr.romaindu35.pufferjavaapi.impl.PufferJavaAPI;
import fr.romaindu35.pufferjavaapi.api.exception.PufferException;

import java.net.URI;

public class Main {

    public static void main(String[] args) throws PufferException {
        PufferJavaAPI pufferJavaAPI = new PufferJavaAPI(new Authentificator(URI.create("panelIP"), "email", "password"));
   

        System.exit(0);
    }

}
