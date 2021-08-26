package fr.romaindu35.pufferjavaapi.api.models;

public class UserView {

    private String email;

    private Integer id;

    private String newPassword;

    private String password;

    private String username;

    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "UserView{" +
                "email='" + email + '\'' +
                ", id='" + id + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", password=" + password +
                ", username=" + username +
                '}';
    }


}
