package fr.romaindu35.pufferjavaapi.api.models;

public class UserSettingView {

    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "UserSettingView{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
