package fr.romaindu35.pufferjavaapi.api.pufferpanel;

import java.util.List;

public class Execution {

    private String[] arguments;
    private boolean autorecover;
    private boolean autorestart;
    private boolean autostart;
    private String command;
    private boolean disabled;
    private List<String> environmentVars;
    private List<String> post;
    private List<String> pre;
    private String program;
    private String stop;
    private Integer stopCode;
    private String workingDirectory;

    public String[] getArguments() {
        return arguments;
    }

    public boolean isAutorecover() {
        return autorecover;
    }

    public boolean isAutorestart() {
        return autorestart;
    }

    public boolean isAutostart() {
        return autostart;
    }

    public String getCommand() {
        return command;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public List<String> getEnvironmentVars() {
        return environmentVars;
    }

    public List<String> getPost() {
        return post;
    }

    public List<String> getPre() {
        return pre;
    }

    public String getProgram() {
        return program;
    }

    public String getStop() {
        return stop;
    }

    public Integer getStopCode() {
        return stopCode;
    }

    public String getWorkingDirectory() {
        return workingDirectory;
    }

    @Override
    public String toString() {
        return "Execution{" +
                "arguments='" + arguments + '\'' +
                "autorecover='" + autorecover + '\'' +
                "autorestart='" + autorestart + '\'' +
                "autostart='" + autostart + '\'' +
                "command='" + command + '\'' +
                "disabled='" + disabled + '\'' +
                "environmentVars='" + environmentVars + '\'' +
                "post='" + post + '\'' +
                "pre='" + pre + '\'' +
                "program='" + program + '\'' +
                "stop='" + stop + '\'' +
                "stopCode='" + stopCode + '\'' +
                "workingDirectory='" + workingDirectory + '\'' +
                '}';
    }

}
