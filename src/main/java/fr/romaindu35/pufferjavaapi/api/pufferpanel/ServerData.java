package fr.romaindu35.pufferjavaapi.api.pufferpanel;

import java.util.List;

public class ServerData {

    private List<Variable> data;

    public List<Variable> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "PufferdRunning{" +
                "data='" + data + '\'' +
                '}';
    }
}
