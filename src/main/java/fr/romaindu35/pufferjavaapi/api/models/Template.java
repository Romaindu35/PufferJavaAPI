package fr.romaindu35.pufferjavaapi.api.models;

import fr.romaindu35.pufferjavaapi.api.pufferpanel.Execution;
import fr.romaindu35.pufferjavaapi.api.pufferpanel.Task;
import fr.romaindu35.pufferjavaapi.api.pufferpanel.Variable;

import java.util.List;

public class Template {

    private Variable data;
    private String display;
    private List<String> environment;
    private String id;
    private List<String> install;
    private String name;
    private String readme;
    private Execution run;
    private List<String> supportedEnvironments;
    private List<Task> tasks;
    private String type;
    private List<String> uninstall;

    public Variable getData() {
        return data;
    }

    public String getDisplay() {
        return display;
    }

    public List<String> getEnvironment() {
        return environment;
    }

    public String getId() {
        return id;
    }

    public List<String> getInstall() {
        return install;
    }

    public String getName() {
        return name;
    }

    public String getReadme() {
        return readme;
    }

    public Execution getRun() {
        return run;
    }

    public List<String> getSupportedEnvironments() {
        return supportedEnvironments;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public String getType() {
        return type;
    }

    public List<String> getUninstall() {
        return uninstall;
    }

    @Override
    public String toString() {
        return "Template{" +
                "data=" + data +
                ", display='" + display + '\'' +
                ", environment=" + environment +
                ", id='" + id + '\'' +
                ", install=" + install +
                ", name='" + name + '\'' +
                ", readme='" + readme + '\'' +
                ", run=" + run +
                ", supportedEnvironments=" + supportedEnvironments +
                ", tasks=" + tasks +
                ", type='" + type + '\'' +
                ", uninstall=" + uninstall +
                '}';
    }
}
