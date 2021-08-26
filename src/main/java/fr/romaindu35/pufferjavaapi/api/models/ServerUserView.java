package fr.romaindu35.pufferjavaapi.api.models;

import java.util.Arrays;

public class ServerUserView {

    private String[] scopes;

    private String username;

    public String[] getScopes() {
        return scopes;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "ServerUserView{" +
                "scopes=" + Arrays.toString(scopes) +
                ", username='" + username + '\'' +
                '}';
    }
}
