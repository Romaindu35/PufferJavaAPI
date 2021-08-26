package fr.romaindu35.pufferjavaapi.api.pufferpanel;

import java.util.List;

public class Task {

    private String cronSchedule;
    private List<String> operations;

    public String getCronSchedule() {
        return cronSchedule;
    }

    public List<String> getOperations() {
        return operations;
    }

    @Override
    public String toString() {
        return "Task{" +
                "cronSchedule='" + cronSchedule + '\'' +
                "operations='" + operations + '\'' +
                '}';
    }
}
