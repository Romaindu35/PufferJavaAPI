package fr.romaindu35.pufferjavaapi.api.models;

public class UserSearch {

    private String email;
    private Integer page;
    private Integer pageLimit;
    private String username;

    public String getEmail() {
        return email;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPageLimit() {
        return pageLimit;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "UserSearch{" +
                "email='" + email + '\'' +
                ", page=" + page +
                ", pageLimit=" + pageLimit +
                ", username='" + username + '\'' +
                '}';
    }
}
