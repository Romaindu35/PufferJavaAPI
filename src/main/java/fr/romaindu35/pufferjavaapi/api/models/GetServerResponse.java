package fr.romaindu35.pufferjavaapi.api.models;

public class GetServerResponse {

    private PermissionView permissions;
    private ServerView server;

    public PermissionView getPermissions() {
        return permissions;
    }

    public ServerView getServer() {
        return server;
    }

    @Override
    public String toString() {
        return "GetServerResponse{" +
                "permissions='" + permissions + '\'' +
                ", server='" + server + '\'' +
                '}';
    }
}
