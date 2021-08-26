package fr.romaindu35.pufferjavaapi.api.pufferpanel;

import java.util.List;

public class Variable {

    private String desc;
    public String display;
    private boolean internal;
    private List<VariableOption> options;
    private boolean required;
    private String type;
    private boolean userEdit;
    private List<String> value;

    public String getDesc() {
        return desc;
    }

    public String getDisplay() {
        return display;
    }

    public boolean isInternal() {
        return internal;
    }

    public List<VariableOption> getOptions() {
        return options;
    }

    public boolean isRequired() {
        return required;
    }

    public String getType() {
        return type;
    }

    public boolean isUserEdit() {
        return userEdit;
    }

    public List<String> getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "desc='" + desc + '\'' +
                "display='" + display + '\'' +
                "internal='" + internal + '\'' +
                "options='" + options + '\'' +
                "required='" + required + '\'' +
                "type='" + type + '\'' +
                "userEdit='" + userEdit + '\'' +
                "value='" + value + '\'' +
                '}';
    }

}
