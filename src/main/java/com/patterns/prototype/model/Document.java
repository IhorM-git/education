package com.patterns.prototype.model;

import java.util.ArrayList;

public class Document extends DocumentPrototype {
    private String title;
    private String content;
    private ArrayList<String> images;

    public Document(String title, String content, ArrayList<String> images) {
        this.title = title;
        this.content = content;
        this.images = images;
    }

    public DocumentPrototype clone() {
        return new Document(this.title, this.content, new ArrayList<>(this.images));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }
}
