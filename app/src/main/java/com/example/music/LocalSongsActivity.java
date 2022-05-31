package com.example.music;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LocalSongsActivity extends AppCompatActivity implements View.OnClickListener{

    private List<Song> songs = null;
    private SongAdapter songAdapter = null;
    private int Icon;

    private LinearLayout ll_songlist_toolbar;
    private ListView list_song;
    private LayoutInflater mInflater;
    private ImageView img_songlist_icon;
    private TextView txt_songlist_intro;
    private ImageView img_pause;

    private CurrentSongApp CSApp;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_songlist);
        bindView();
        songs = (List<Song>) getIntent().getSerializableExtra("song_list");
        Icon = getIntent().getIntExtra("song_icon", 0);
//        songs.add(new Song("海阔天空", "Beyond", R.drawable.actionbar_music_normal));
//        songs.add(new Song("白玫瑰", "陈奕迅", R.drawable.actionbar_music_normal));
//        songs.add(new Song("Desperato", "Eagles", R.drawable.actionbar_music_normal));
        mInflater = LocalSongsActivity.this.getLayoutInflater();
        if (songs != null) {
            songAdapter = new SongAdapter((ArrayList<Song>) songs, mInflater);
            list_song.setAdapter(songAdapter);

            list_song.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Song current_play = songs.get(position);
                    /*Set the playing song field here
                     * Code:
                     * */
                }
            });
        }


        if (!CSApp.getPlayState()) {
            img_pause.setBackgroundResource(R.drawable.playbar_btn_pause);
        }
        else {
            img_pause.setBackgroundResource(R.drawable.playbar_btn_play);
        }

        img_songlist_icon.setBackgroundResource(Icon);
    }

    private void bindView() {
        list_song = (ListView) findViewById(R.id.list_song);
        ll_songlist_toolbar = (LinearLayout) findViewById(R.id.ll_songlist_toolbar);
        img_songlist_icon = (ImageView) findViewById(R.id.img_songlist_icon);
        txt_songlist_intro = (TextView) findViewById(R.id.txt_songlist_intro);

        img_pause = (ImageView) findViewById(R.id.img_pause);

        img_pause.setOnClickListener(this);

        CSApp = (CurrentSongApp) getApplication();
        CSApp.setPlayState(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_pause:
                if (CSApp.getPlayState()) {
                    CSApp.setPlayState(false);
                    img_pause.setBackgroundResource(R.drawable.playbar_btn_pause);
                }
                else {
                    CSApp.setPlayState(true);
                    img_pause.setBackgroundResource(R.drawable.playbar_btn_play);
                }
                // showAllFragment(fTransaction);
                break;
        }
    }
}
