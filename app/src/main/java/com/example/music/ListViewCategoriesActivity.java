package com.example.music;  // Change this to your actual package name

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ListViewCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.list_view_categories); // Set the content view to your list_view_categories.xml
            String imageViewTag = getIntent().getStringExtra("imageViewTag");

            DatabaseHelper db = new DatabaseHelper(ListViewCategoriesActivity.this);
            ListView listView = findViewById(R.id.listViewCategories);
            db.deleteAllSongs();
            this.deleteDatabase(DatabaseHelper.DATABASE_NAME);

            db.addGenre("Pop");
            db.addGenre("Ballad");

            db.addSong("Happy", "duc  HUNG 2", "Pop", R.raw.happy);
            db.addSong("Sao em lại tắt máy", "duc  HUNG 3", "Ballad", R.raw.saoemlaitatmay);
            db.addSong("bgm", "duc  HUNG 1", "Pop", R.raw.bgm);
            db.addSong("Lời tâm sự số 3", "duc  HUNG 4", "Meo", R.raw.loitamsuso3);
            db.addSong("Lời tâm sự số 4", "duc  HUNG 4", "House", R.raw.loitamsuso3);
            List<Song> songList = db.getAllSongs();
            ArrayAdapter<Song> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, songList);
            listView.setAdapter(arrayAdapter);
        }
}
