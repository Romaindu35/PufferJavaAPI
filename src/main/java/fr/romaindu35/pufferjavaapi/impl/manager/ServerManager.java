package fr.romaindu35.pufferjavaapi.impl.manager;

import fr.romaindu35.pufferjavaapi.api.exception.PufferException;
import fr.romaindu35.pufferjavaapi.api.models.NodeView;
import fr.romaindu35.pufferjavaapi.api.models.ServerView;
import fr.romaindu35.pufferjavaapi.api.pufferpanel.ServerLogs;
import fr.romaindu35.pufferjavaapi.api.pufferpanel.ServerStats;
import fr.romaindu35.pufferjavaapi.impl.PufferJavaAPI;

public class ServerManager extends ServerView {

    private PufferJavaAPI pufferJavaAPI;

    ServerManager(PufferJavaAPI pufferJavaAPI, String id, String ip, String name, NodeView node, Integer nodeId, Integer port, String type) {
        super(id, ip, name, node, nodeId, port, type);
        this.pufferJavaAPI = pufferJavaAPI;
    }

    ServerManager(PufferJavaAPI pufferJavaAPI, ServerView serverView) {
        this(pufferJavaAPI, serverView.getId(), serverView.getIp(), serverView.getName(), serverView.getNode(), serverView.getNodeId(), serverView.getPort(), serverView.getType());
    }

    /**
     * Delete the server
     * @throws PufferException
     */
    public void delete() throws PufferException {
        pufferJavaAPI.logger.info("The server " + id + " has been deleted.");
        pufferJavaAPI.send(pufferJavaAPI.getRequest().deleteServer(id));
    }

    /**
     * Get server's logs
     * @return ServerLogs class with we can get epoch ({@link ServerLogs#getEpoch()}) and logs ({@link ServerLogs#getLogs()})
     * @throws PufferException
     */
    public ServerLogs getLogs() throws PufferException {
        pufferJavaAPI.logger.info("Logs has been get for server " + id + ".");
        return pufferJavaAPI.send(pufferJavaAPI.getRequest().getServerLogs(id));
    }

    /**
     * Start the server
     * @param wait : if true, the server wait start finish before execute other task
     * @throws PufferException
     */
    public void start(boolean wait) throws PufferException {
        pufferJavaAPI.send(pufferJavaAPI.getRequest().startServer(id, wait));
        if (wait)
            pufferJavaAPI.logger.info("The server " + id + " has been started and wait start finish before execute other task.");
        else
            pufferJavaAPI.logger.info("The server " + id + " has been started.");
    }

    /**
     * Stop the server
     * @param wait : if true, the server wait stop finish before execute other task
     * @throws PufferException
     */
    public void stop(boolean wait) throws PufferException {
        pufferJavaAPI.send(pufferJavaAPI.getRequest().stopServer(id, wait));
        if (wait)
            pufferJavaAPI.logger.info("The server " + id + " has been stopped and wait stop finish before execute other task.");
        else
            pufferJavaAPI.logger.info("The server " + id + " has been stopped.");
    }

    /**
     * Install the server
     * @param wait : if true, the server wait install finish before execute other task
     * @throws PufferException
     */
    public void install(boolean wait) throws PufferException {
        pufferJavaAPI.send(pufferJavaAPI.getRequest().installServer(id, wait));
        if (wait)
            pufferJavaAPI.logger.info("The server " + id + " has been installed and wait install finish before execute other task.");
        else
            pufferJavaAPI.logger.info("The server " + id + " has been installed.");
    }

    /**
     * Reload the server
     * @throws PufferException
     */
    public void reload() throws PufferException {
        pufferJavaAPI.send(pufferJavaAPI.getRequest().reloadServer(id));
        pufferJavaAPI.logger.info("The server " + id + " has been reloaded.");
    }

    /**
     * Kill the server
     * @throws PufferException
     */
    public void kill() throws PufferException {
        pufferJavaAPI.send(pufferJavaAPI.getRequest().killServer(id));
        pufferJavaAPI.logger.info("The server " + id + " has been killed.");
    }

    /**
     * Get cpu and memory used by the server
     * @return ServerStats with we can get cpu ({@link ServerStats#getCpu()}) and memory ({@link ServerStats#getMemory()})
     * @throws PufferException
     */
    public ServerStats getStats() throws PufferException {
        pufferJavaAPI.logger.info("ServerStats has been get for server " + id + ".");
        return pufferJavaAPI.send(pufferJavaAPI.getRequest().getServerStats(id));
    }

    /**
     * Get the server status (The server is running or not)
     * @return Return true if server is running
     * @throws PufferException
     */
    public boolean getStatus() throws PufferException {
        pufferJavaAPI.logger.info("Status has been get for server " + id + ".");
        return pufferJavaAPI.send(pufferJavaAPI.getRequest().getServerStatus(id)).isRunning();
    }

}
