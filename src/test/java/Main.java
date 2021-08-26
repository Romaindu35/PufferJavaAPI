import fr.romaindu35.pufferjavaapi.api.Authentificator;
import fr.romaindu35.pufferjavaapi.impl.PufferJavaAPI;
import fr.romaindu35.pufferjavaapi.api.exception.PufferException;

import java.net.URI;

public class Main {

    public static void main(String[] args) throws PufferException {
        PufferJavaAPI pufferJavaAPI = new PufferJavaAPI(new Authentificator(URI.create("https://puffer.envium.fr/"), "romain.sai-tanguy@sfr.fr", "Romain35"));

        /*System.out.println(pufferJavaAPI.send(pufferJavaAPI.getRequest().getServers()).getServers());

        PermissionView permissionView = pufferJavaAPI.send(pufferJavaAPI.getRequest().getUserAccessServer("ada473e9")).get(0);
        pufferJavaAPI.send(pufferJavaAPI.getRequest().editUserAccessServerPermission("ada473e9", ""))*/

        System.out.println(pufferJavaAPI.send(pufferJavaAPI.getRequest().isDaemonUp()));
        pufferJavaAPI.getNodesManager().getServerByName("default");

        System.exit(0);
    }

}
