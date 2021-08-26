package fr.romaindu35.pufferjavaapi.api.models;

public class ServerView {

    protected String id;
    protected String ip;
    protected String name;
    protected NodeView node;
    protected Integer nodeId;
    protected Integer port;
    protected String type;

    protected ServerView(String id, String ip, String name, NodeView node, Integer nodeId, Integer port, String type) {
        this.id = id;
        this.ip = ip;
        this.name = name;
        this.node = node;
        this.nodeId = nodeId;
        this.port = port;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }

    public NodeView getNode() {
        return node;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public Integer getPort() {
        return port;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ServerView{" +
                "id='" + id + '\'' +
                ", ip='" + ip + '\'' +
                ", name='" + name + '\'' +
                ", node=" + node +
                ", nodeId=" + nodeId +
                ", port=" + port +
                ", type='" + type + '\'' +
                '}';
    }

}
