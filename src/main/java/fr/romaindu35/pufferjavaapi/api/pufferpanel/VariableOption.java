package fr.romaindu35.pufferjavaapi.api.pufferpanel;

import java.util.List;

public class VariableOption {

    private String display;
    private List<String> value;

    public String getDisplay() {
        return display;
    }

    public List<String> getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "VariableOption{" +
                "display='" + display + '\'' +
                "value='" + value + '\'' +
                '}';
    }
}
