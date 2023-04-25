package com.example.notebookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class NoteDetailActivity extends AppCompatActivity {

    TextView view_title, view_category, view_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);

        view_title = findViewById(R.id.view_title);
        view_category = findViewById(R.id.view_category);
        view_description = findViewById(R.id.view_description);

        Intent intent = getIntent();

        String title = intent.getExtras().getString("title");
        String description = intent.getExtras().getString("description");
        String category = intent.getExtras().getString("category");

        view_title.setText(title);
        view_description.setText(description);
        view_category.setText(category);

    }
}