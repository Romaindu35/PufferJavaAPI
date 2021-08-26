package fr.romaindu35.pufferjavaapi.impl.manager;

import fr.romaindu35.pufferjavaapi.api.exception.PufferException;
import fr.romaindu35.pufferjavaapi.impl.PufferJavaAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ServersManager extends Manager {


    public ServersManager(PufferJavaAPI pufferJavaAPI) {
        super(pufferJavaAPI);
    }

    /**
     * Get list of all servers
     * @return List of ServerManager
     * @throws PufferException
     */
    public List<ServerManager> getServers() throws PufferException {
        List<ServerManager> serverManagerList = new ArrayList<>();
        pufferJavaAPI.send(pufferJavaAPI.getRequest().getServers()).getServers().forEach(serverView -> {
            serverManagerList.add(new ServerManager(pufferJavaAPI, serverView));
        });
        return serverManagerList;
    }

    /**
     * Get ServerManager with his id
     * @param serverId : Id of the server that we want to get
     * @return ServerManager depending on the server id asked
     * @throws PufferException
     */
    public ServerManager getServerById(String serverId) throws PufferException {
        return new ServerManager(pufferJavaAPI, pufferJavaAPI.send(pufferJavaAPI.getRequest().getServer(serverId)).getServer());
    }

    /**
     * Get ServerManager with his name
     * @param serverName : Name of the server that we want to get
     * @return ServerManager depending on the server name asked
     * @throws PufferException
     */
    public ServerManager getServerByName(String serverName) throws PufferException {
        AtomicReference<ServerManager> serverManager = null;
        pufferJavaAPI.send(pufferJavaAPI.getRequest().getServers()).getServers().forEach(serverView -> {
            if (serverView.getName().equalsIgnoreCase(serverName))
                serverManager.set(new ServerManager(pufferJavaAPI, serverView));
        });
        return serverManager.get();
    }
    
}
