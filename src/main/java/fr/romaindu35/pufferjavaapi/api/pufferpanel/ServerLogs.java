package fr.romaindu35.pufferjavaapi.api.pufferpanel;

public class ServerLogs {

    private Integer epoch;
    private String logs;

    public Integer getEpoch() {
        return epoch;
    }

    public String getLogs() {
        return logs;
    }

    @Override
    public String toString() {
        return "ServerLogs{" +
                "epoch='" + epoch + '\'' +
                "logs='" + logs + '\'' +
                '}';
    }
}
