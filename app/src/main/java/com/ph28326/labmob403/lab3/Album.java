package com.ph28326.labmob403.lab3;

public class Album {
    private int id;
    private String title;
    private String url;

    public Album(int id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}