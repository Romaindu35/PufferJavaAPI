package fr.romaindu35.pufferjavaapi.api.pufferpanel;

public class ServerStats {

    private Integer cpu;
    private Integer memory;

    public Integer getCpu() {
        return cpu;
    }

    public Integer getMemory() {
        return memory;
    }

    @Override
    public String toString() {
        return "ServerStats{" +
                "cpu='" + cpu + '\'' +
                "memory='" + memory + '\'' +
                '}';
    }
}
