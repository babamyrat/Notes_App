package com.example.notesapp.domain;

import com.example.notesapp.R;

import java.util.ArrayList;
import java.util.List;

public class DeviceNotesRepository implements NotesRepository {

    @Override
    public List<Note> getNotes() {
        ArrayList<Note> notes = new ArrayList<>();

        notes.add(new Note(R.string.name1, R.string.text1));
        notes.add(new Note(R.string.name2, R.string.text2));
        notes.add(new Note(R.string.name3, R.string.text3));
        notes.add(new Note(R.string.name4, R.string.text4));
        notes.add(new Note(R.string.name5, R.string.text5));
        notes.add(new Note(R.string.name6, R.string.text6));

        return notes;
    }
}
