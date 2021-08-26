package fr.romaindu35.pufferjavaapi.api.models;

import java.util.List;

public class PufferSession {

    private String session;

    private List<String> scopes;

    public String getSession() {
        return session;
    }

    public List<String> getScopes() {
        return scopes;
    }

    @Override
    public String toString() {
        return "PufferSession{" +
                "session='" + session + '\'' +
                ", scopes=" + scopes +
                '}';
    }
}
