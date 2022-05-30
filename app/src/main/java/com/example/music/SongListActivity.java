package com.example.music;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SongListActivity extends AppCompatActivity implements View.OnClickListener{

    private List<Song> songs = null;
    private SongAdapter songAdapter = null;

    private LinearLayout ll_songlist_toolbar;
    private ListView list_song;
    private LayoutInflater mInflater;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_songlist);
        bindView();
        songs = (List<Song>) getIntent().getSerializableExtra("song_list");
        songs.add(new Song("海阔天空", "Beyond", R.drawable.actionbar_music_normal));
        songs.add(new Song("白玫瑰", "陈奕迅", R.drawable.actionbar_music_normal));
        songs.add(new Song("Desperato", "Eagles", R.drawable.actionbar_music_normal));
        mInflater = SongListActivity.this.getLayoutInflater();
        songAdapter = new SongAdapter((ArrayList<Song>) songs, mInflater);
        list_song.setAdapter(songAdapter);
    }

    private void bindView() {
        list_song = (ListView) findViewById(R.id.list_song);
        ll_songlist_toolbar = (LinearLayout) findViewById(R.id.ll_songlist_toolbar);
    }

    @Override
    public void onClick(View v) {

    }
}
