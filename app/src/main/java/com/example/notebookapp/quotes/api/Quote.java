package com.example.notebookapp.quotes.api;

import com.google.gson.annotations.SerializedName;

public class Quote {
    @SerializedName("a")
    String author;

    @SerializedName("q")
    String quote;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

}
