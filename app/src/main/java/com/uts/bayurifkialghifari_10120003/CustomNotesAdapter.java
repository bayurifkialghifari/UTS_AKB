package com.uts.bayurifkialghifari_10120003;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomNotesAdapter extends RecyclerView.Adapter<CustomNotesAdapter.MyViewHolder> {

    Context ctx;
    ArrayList<NoteModel> notes;

    public CustomNotesAdapter(Context context, ArrayList<NoteModel> notes) {
        this.ctx = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.notes_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.v_note_id.setText(String.valueOf(notes.get(position).id));
        holder.v_note_title.setText(String.valueOf(notes.get(position).title));
        holder.v_note_category.setText(String.valueOf(notes.get(position).category));
        holder.v_note_created_at.setText(String.valueOf(notes.get(position).created_at));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView v_note_id, v_note_category, v_note_title, v_note_created_at;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            v_note_id = itemView.findViewById(R.id.v_note_id);
            v_note_category = itemView.findViewById(R.id.v_note_category);
            v_note_title = itemView.findViewById(R.id.v_note_title);
            v_note_created_at = itemView.findViewById(R.id.v_note_created_at);
        }
    }
}
