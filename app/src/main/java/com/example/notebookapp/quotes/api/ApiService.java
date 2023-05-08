package com.example.notebookapp.quotes.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("quotes")
    Call<List <Quote> > getQuotes();

}
