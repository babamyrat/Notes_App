package com.example.notesapp.ui.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.notesapp.R;
import com.example.notesapp.domain.Note;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {


private final ArrayList<Note> data = new ArrayList<>();
private OnNoteClickedListener listener;

    public void setNotes(List<Note> toSet) {
     data.clear();
     data.addAll(toSet);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public NotesAdapter.NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);

        return new NotesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.NotesViewHolder holder, int position) {
        Note note = data.get(position);
        holder.title.setText(note.getName());

        Glide.with(holder.image).load(note.getImage()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setListener(OnNoteClickedListener listener) {
        this.listener = listener;
    }

    public OnNoteClickedListener getListener() {
        return listener;
    }

    interface OnNoteClickedListener {
        void onNoteClicked(Note note);
    }

    class NotesViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final ImageView image;


        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(getListener() != null){
                        getListener().onNoteClicked(data.get(getAdapterPosition()));
                    }

                }
            });

            title = itemView.findViewById(R.id.txtName);
            image = itemView.findViewById(R.id.img_image);

        }

        public TextView getTitle() {
            return title;
        }

        public ImageView getImage() {
            return image;
        }
    }
}
