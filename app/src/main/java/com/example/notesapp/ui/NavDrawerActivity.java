package com.example.notesapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.notesapp.R;
import com.example.notesapp.domain.Note;
import com.example.notesapp.ui.details.NoteDetailsActivity;
import com.example.notesapp.ui.details.NoteDetailsFragment;
import com.example.notesapp.ui.list.NotesListFragment;
import com.google.android.material.navigation.NavigationView;

public class NavDrawerActivity extends AppCompatActivity implements NotesListFragment.OnNoteClicked  {

    private static final String ARG_NOTE = "ARG_NOTE";
    private Note selectedNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new NotesListFragment())
                    .commit();

        }

        Toolbar toolbar = findViewById(R.id.toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.open_drawer,
                R.string.close_drawer);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.action_one) {

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container, new NotesListFragment())
                            .commit();

                    drawerLayout.closeDrawer(GravityCompat.START);

                    return true;
                }

                if (item.getItemId() == R.id.action_two) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container, new EmptyFragment())
                            .commit();

                    drawerLayout.closeDrawer(GravityCompat.START);

                    return true;
                }

                return false;
            }
        });

    }

    @Override
    public void onNoteOnClicked(Note note) {
        selectedNote = note;
        if (getResources().getBoolean(R.bool.isLandscape)){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.details_container, NoteDetailsFragment.newInstance(note), null)
                    .commit();

        } else {
            Intent intent = new Intent(this, NoteDetailsActivity.class);
            intent.putExtra(NoteDetailsActivity.ARG_NOTE, note);
            startActivity(intent);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        if (selectedNote != null){
            outState.putParcelable(ARG_NOTE, selectedNote);
        }
        super.onSaveInstanceState(outState);

    }
}