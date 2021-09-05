package com.example.notesapp.ui.list;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.notesapp.R;
import com.example.notesapp.domain.DeviceNotesRepository;
import com.example.notesapp.domain.Note;

import java.util.List;


public class NotesListFragment extends Fragment implements NotesListView {

    public interface OnNoteClicked{
        void onNoteOnClicked(Note note);
    }

    public static final String KEY_SELECTED_NOTE = "KEY_SELECTED_CITY";
    public static final String ARG_NOTE = "ARG_CITY";

    private NotesListPresenter presenter;
    private LinearLayout container;
    private OnNoteClicked onNoteClicked;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnNoteClicked) {
            onNoteClicked = (OnNoteClicked) context;
        }
    }

    @Override
    public void onDetach() {
        onNoteClicked = null;
        super.onDetach();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new NotesListPresenter(this, new DeviceNotesRepository());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        container = view.findViewById(R.id.root);
        presenter.requestNotes();

    }

    @Override
    public void showNotes(List<Note> notes) {

        for (Note note: notes) {
            View noteItem = LayoutInflater.from(requireContext()).inflate(R.layout.note_item, container, false);

            noteItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onNoteClicked != null){
                        onNoteClicked.onNoteOnClicked(note);
                    }

                    Bundle bundle = new Bundle();
                    bundle.putParcelable(ARG_NOTE, note);

                    getParentFragmentManager().setFragmentResult(KEY_SELECTED_NOTE, bundle);

                }
            });

            TextView noteName = noteItem.findViewById(R.id.txtName);
            noteName.setText(note.getName());
            container.addView(noteItem);
        }

    }
}