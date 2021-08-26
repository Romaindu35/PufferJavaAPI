package fr.romaindu35.pufferjavaapi.api;

import java.net.URI;

public class Authentificator {

    private final URI uri;
    private final String email;
    private final String password;

    public Authentificator(URI uri, String email, String password) {
        this.uri = uri;
        this.email = email;
        this.password = password;
    }

    public URI getURI() {
        return uri;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDomain() {
        String domain = this.uri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }
}
