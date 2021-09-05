package com.example.notesapp.ui.details;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.notesapp.R;
import com.example.notesapp.domain.Note;
import com.example.notesapp.ui.list.NotesListFragment;


public class NoteDetailsFragment extends Fragment {

    public static final String ARG_NOTE = "ARG_NOTE";
    private TextView txtName;
    private TextView txtText;


    public NoteDetailsFragment() {
        super(R.layout.fragment_note_details);
    }

    public static NoteDetailsFragment newInstance(Note note) {
        NoteDetailsFragment fragment = new NoteDetailsFragment();
        Bundle argument = new Bundle();
        argument.putParcelable(ARG_NOTE, note);

        fragment.setArguments(argument);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtName = view.findViewById(R.id.txtName);
        txtText = view.findViewById(R.id.txtText);

        getParentFragmentManager().setFragmentResultListener(NotesListFragment.KEY_SELECTED_NOTE, getViewLifecycleOwner(), new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

                Note note = result.getParcelable(NotesListFragment.ARG_NOTE);

                displayNote(note);

            }
        });

        if (getArguments() != null && getArguments().containsKey(ARG_NOTE)){

            Note note = getArguments().getParcelable(ARG_NOTE);
            if (note != null){
                displayNote(note);
            }

        }

    }

    private void displayNote(Note note) {
        txtName.setText(note.getName());
        txtText.setText(note.getText());
    }


}