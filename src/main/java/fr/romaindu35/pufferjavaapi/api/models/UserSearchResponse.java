package fr.romaindu35.pufferjavaapi.api.models;

import fr.romaindu35.pufferjavaapi.api.reponse.Paging;

import java.util.List;

public class UserSearchResponse {

    private Paging paging;
    private List<UserView> users;

    public Paging getPaging() {
        return paging;
    }

    public List<UserView> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "UserSearchResponse{" +
                "paging=" + paging +
                ", users=" + users +
                '}';
    }
}
