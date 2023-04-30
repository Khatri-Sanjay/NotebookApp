package com.example.notebookapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class NoteColorAdapter extends RecyclerView.Adapter<NoteColorAdapter.NotesColorViewHolder> {

    ArrayList<Integer> colors;
    NoteColorListner noteColorListner;

    public NoteColorAdapter(ArrayList<Integer> colors,NoteColorListner listner) {
        this.colors = colors;
        this.noteColorListner = listner;
    }


    @NonNull
    @Override
    public NotesColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note_color, parent, false);
        return new NotesColorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesColorViewHolder holder, int position) {
        holder.bindView(colors.get(position));
    }

    @Override
    public int getItemCount() {
        return colors.size();
    }

    class NotesColorViewHolder extends RecyclerView.ViewHolder {

        MaterialCardView cardColor;

        public NotesColorViewHolder(@NonNull View itemView) {
            super(itemView);
            cardColor = itemView.findViewById(R.id.cardColor);
        }

        public void bindView(int color) {
            cardColor.setCardBackgroundColor(color);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    noteColorListner.onNoteColorClicked(color);
                }
            });
        }
    }
}
