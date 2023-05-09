package com.example.notebookapp.quotes.api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.notebookapp.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuotesActivity extends AppCompatActivity {

    RecyclerView quotesrv;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_quotes);
        quotesrv = findViewById(R.id.quoteList);
        progressBar = findViewById(R.id.progressBar);

        ApiService service = RetrofitClient.getRetrofit().create(ApiService.class);
        service.getQuotes().enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                Log.d("tag", "response size is : " + response.body().size());
                progressBar.setVisibility(View.GONE);
                for (Quote quote: response.body()) {
                    Log.d("tag", quote.getAuthor());
                    Log.d("tag", quote.getQuote());
                }

                QuoteAdapter adapter = new QuoteAdapter(response.body());
                quotesrv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {

            }
        });
    }
}