package com.jakarta.play.blog;

public final class Topic {

    private int id;
    private String title;
    private String url;

    public Topic(String title, String url, int id) {
        this.title = title;
        this.url = url;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
