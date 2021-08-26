package fr.romaindu35.pufferjavaapi.api.models;

import fr.romaindu35.pufferjavaapi.api.reponse.Paging;

import java.util.List;

public class ServerSearchResponse {

    private Paging paging;

    private List<ServerView> servers;

    public Paging getPaging() {
        return paging;
    }

    public List<ServerView> getServers() {
        return servers;
    }

    @Override
    public String toString() {
        return "ServerSearchResponse{" +
                "paging=" + paging +
                ", servers=" + servers +
                '}';
    }
}
