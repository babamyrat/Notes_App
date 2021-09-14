package com.example.notesapp.domain;

import com.example.notesapp.R;

import java.util.ArrayList;
import java.util.List;

public class DeviceNotesRepository implements NotesRepository {

    @Override
    public List<Note> getNotes() {
        ArrayList<Note> notes = new ArrayList<>();

        notes.add(new Note(R.string.name1, R.string.text1,"https://w-dog.ru/wallpapers/15/14/530066962983792/kamni-krasochnye-galka.jpg" ));
        notes.add(new Note(R.string.name2, R.string.text2,"https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Ho_Chi_Minh_City_Skyline_%28night%29.jpg/1200px-Ho_Chi_Minh_City_Skyline_%28night%29.jpg"));
        notes.add(new Note(R.string.name3, R.string.text3, "https://mocah.org/uploads/posts/4575567-nature-mountains-lake-forest-trees-moraine-lake.jpg"));
        notes.add(new Note(R.string.name4, R.string.text4, "https://million-wallpapers.ru/wallpapers/0/7/528843552995332/prekrasnyj-vid-priroda.jpg"));
        notes.add(new Note(R.string.name5, R.string.text5, "https://cdn.fishki.net/upload/post/2017/02/15/2219607/1f4840724fbae6a80715522d8ee4cc86.jpg"));
        notes.add(new Note(R.string.name6, R.string.text6, "https://img2.goodfon.ru/wallpaper/original/b/99/yuzhnaya-amerika-chili-patagoniya-1452.jpg"));

        return notes;

    }
}
