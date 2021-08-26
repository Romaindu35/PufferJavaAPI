package fr.romaindu35.pufferjavaapi.api.reponse;

public class Paging {

    private Integer maxSize;
    private Integer page;
    private Integer pageSize;
    private Integer total;

    public Integer getMaxSize() {
        return maxSize;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Paging{" +
                "maxSize='" + maxSize + '\'' +
                "page='" + page + '\'' +
                "pageSize='" + pageSize + '\'' +
                "total='" + total + '\'' +
                '}';
    }
}
