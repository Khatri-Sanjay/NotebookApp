package com.example.notebookapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton btnAddNote;
    ArrayList<Note> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notes = new ArrayList<>();
        notes.add(new Note("Note 1","Description 1","Category 1"));
        notes.add(new Note("Note 2","Description 2","Category 2"));
        notes.add(new Note("Note 3","Description 3","Category 3"));
        notes.add(new Note("Note 4","Description 4","Category 4"));
        notes.add(new Note("Note 5","Description 5","Category 5"));


        btnAddNote = findViewById(R.id.btnAddNote);
        RecyclerView rv = findViewById(R.id.recycleview_notes);
        rv.setAdapter(new NotesAdapter(notes));

        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddNotesActivity.class);
                startActivity(intent);
            }
        });

    }
}