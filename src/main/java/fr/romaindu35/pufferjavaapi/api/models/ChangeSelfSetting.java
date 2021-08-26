package fr.romaindu35.pufferjavaapi.api.models;

public class ChangeSelfSetting {

    private String email;
    private String password;
    private String username;

    /**
     * Create a self update object in order to update your current user.
     *
     * @param email The new email address.
     * @param password The new password.
     * @param username The new username.
     */
    public ChangeSelfSetting(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "ChangeSelfSetting{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

}
