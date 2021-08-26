package fr.romaindu35.pufferjavaapi.api.models;

public class ChangeUserSetting {

    private String value;

    public ChangeUserSetting(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ChangeUserSetting{" +
                "value='" + value + '\'' +
                '}';
    }
}
