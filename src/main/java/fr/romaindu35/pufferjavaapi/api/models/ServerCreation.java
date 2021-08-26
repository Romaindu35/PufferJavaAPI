package fr.romaindu35.pufferjavaapi.api.models;

import fr.romaindu35.pufferjavaapi.api.pufferpanel.Execution;
import fr.romaindu35.pufferjavaapi.api.pufferpanel.Task;
import fr.romaindu35.pufferjavaapi.api.pufferpanel.Variable;

import java.util.List;

public class ServerCreation {

    private Variable data;
    private String display;
    private List<String> environment;
    private String id;
    private List<String> install;
    private String name;
    private Integer node;
    private Execution run;
    private List<Task> tasks;
    private String type;
    private List<String> uninstall;
    private List<String> users;

    public ServerCreation(Variable data, String display, List<String> environment, String id, List<String> install, String name, Integer node, Execution run, List<Task> tasks, String type, List<String> uninstall, List<String> users) {
        this.data = data;
        this.display = display;
        this.environment = environment;
        this.id = id;
        this.install = install;
        this.name = name;
        this.node = node;
        this.run = run;
        this.tasks = tasks;
        this.type = type;
        this.uninstall = uninstall;
        this.users = users;
    }

    public Variable getData() {
        return data;
    }

    public void setData(Variable data) {
        this.data = data;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public List<String> getEnvironment() {
        return environment;
    }

    public void setEnvironment(List<String> environment) {
        this.environment = environment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getInstall() {
        return install;
    }

    public void setInstall(List<String> install) {
        this.install = install;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNode() {
        return node;
    }

    public void setNode(Integer node) {
        this.node = node;
    }

    public Execution getRun() {
        return run;
    }

    public void setRun(Execution run) {
        this.run = run;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getUninstall() {
        return uninstall;
    }

    public void setUninstall(List<String> uninstall) {
        this.uninstall = uninstall;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "ServerCreation{" +
                "data=" + data +
                ", display='" + display + '\'' +
                ", environment=" + environment +
                ", id='" + id + '\'' +
                ", install=" + install +
                ", name='" + name + '\'' +
                ", node=" + node +
                ", run=" + run +
                ", tasks=" + tasks +
                ", type='" + type + '\'' +
                ", uninstall=" + uninstall +
                ", users=" + users +
                '}';
    }
}
