package fr.romaindu35.pufferjavaapi.api.messages;

public class FileDesc {

    private String extension;
    private boolean isFile;
    private Integer modifyTime;
    private String name;
    private Integer size;

    public String getExtension() {
        return extension;
    }

    public boolean isFile() {
        return isFile;
    }

    public Integer getModifyTime() {
        return modifyTime;
    }

    public String getName() {
        return name;
    }

    public Integer getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "FileDesc{" +
                "extension='" + extension + '\'' +
                "isFile='" + isFile + '\'' +
                "modifyTime='" + modifyTime + '\'' +
                "name='" + name + '\'' +
                "size='" + size + '\'' +
                '}';
    }
}
