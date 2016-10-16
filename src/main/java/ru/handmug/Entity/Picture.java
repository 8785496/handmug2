package ru.handmug.Entity;

public class Picture {
    private int id;
    private String name;
    private String fileNameMiddle;
    private String fileNameSmall;

    public Picture(int id, String name, String fileNameMiddle, String fileNameSmall) {
        this.id = id;
        this.name = name;
        this.fileNameMiddle = fileNameMiddle;
        this.fileNameSmall = fileNameSmall;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileNameMiddle() {
        return fileNameMiddle;
    }

    public void setFileNameMiddle(String fileNameMiddle) {
        this.fileNameMiddle = fileNameMiddle;
    }

    public String getFileNameSmall() {
        return fileNameSmall;
    }

    public void setFileNameSmall(String fileNameSmall) {
        this.fileNameSmall = fileNameSmall;
    }
}
