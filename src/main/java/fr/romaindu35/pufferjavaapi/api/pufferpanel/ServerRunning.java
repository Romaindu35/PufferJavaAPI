package fr.romaindu35.pufferjavaapi.api.pufferpanel;

public class ServerRunning {

    private boolean running;

    public boolean isRunning() {
        return running;
    }

    @Override
    public String toString() {
        return "ServerRunning{" +
                "running='" + running + '\'' +
                '}';
    }
}
