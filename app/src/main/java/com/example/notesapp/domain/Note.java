package com.example.notesapp.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {

    private int name;
    private int text;

    public Note(int name, int text) {
        this.name = name;
        this.text = text;
    }

    protected Note(Parcel in) {
        name = in.readInt();
        text = in.readInt();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getText() {
        return text;
    }

    public void setText(int text) {
        this.text = text;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(name);
        parcel.writeInt(text);
    }
}
