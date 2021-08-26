package fr.romaindu35.pufferjavaapi.api.models;

public class SettingResponse {

    private String value;

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SettingResponse{" +
                "value='" + value + '\'' +
                '}';
    }
}
