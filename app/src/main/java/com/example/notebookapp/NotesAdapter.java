package com.example.notebookapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    ArrayList<Note> notes;
    NoteListener listener;

    public NotesAdapter(ArrayList<Note> notes,NoteListener noteListener) {
        this.notes = notes;
        this.listener = noteListener;
    }

    public void addData(Note note){
        notes.add(note);
        notifyItemInserted(notes.size());
    }

    public void deleteNote(Note note) {
        Integer index = notes.indexOf(note);
        notes.remove(index);
        notifyItemRangeChanged(0, notes.size());
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_view,parent,false);
        return new  NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.bindView(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NotesViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView description, category;
        MaterialCardView cardNote;
        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);

            category = itemView.findViewById(R.id.display_note_category);
            title = itemView.findViewById(R.id.display_note_title);
            description = itemView.findViewById(R.id.display_note_description);
            cardNote = itemView.findViewById(R.id.cardViewColor);
        }

        public void bindView(Note note){
            category.setText(note.getCategory());
            title.setText(note.getTitle());
            description.setText(note.getDescription());
            cardNote.setCardBackgroundColor(note.getColor());


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onNoteClick(note);
                }
            });


            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.onNoteDelete(note);
                    return false;
                }
            });
        }
    }
}
