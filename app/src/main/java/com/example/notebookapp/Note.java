package com.example.notebookapp;

public class Note {
    String title, description, categoty;

    public Note(String title, String description, String categoty) {
        this.title = title;
        this.description = description;
        this.categoty = categoty;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategoty() {
        return categoty;
    }
}
