package com.example.notebookapp;

import android.content.Intent;

public class Note {
    String title, description, categoty;
    Integer color;

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
