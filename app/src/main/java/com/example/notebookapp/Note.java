package com.example.notebookapp;

import android.content.Intent;

public class Note {
    String title, description, categoty;
    Integer color;
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Note(String title, String description, String categoty, Integer color, Long id) {
        this.title = title;
        this.description = description;
        this.categoty = categoty;
        this.color = color;
        this.id = id;
    }

    public Note(String title, String description, String categoty, Integer color) {
        this.title = title;
        this.description = description;
        this.categoty = categoty;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return categoty;
    }
    public Integer getColor() {
        return color;
    }
}
