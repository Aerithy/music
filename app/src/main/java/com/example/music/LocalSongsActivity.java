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
import java.util.List;

public class LocalSongsActivity extends AppCompatActivity implements View.OnClickListener{

    private List<Song> songs = null;
    private SongAdapter songAdapter = null;
    private int Icon;

    private LinearLayout ll_songlist_toolbar;
    private ListView list_song;
    private LayoutInflater mInflater;
    private ImageView img_song_icon;
    private TextView txt_Songname;
    private TextView txt_singer;
    private ImageView img_pause;

    private CurrentSongApp CSApp;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_localsongs);

        bindView();
//        songs.add(new Song("海阔天空", "Beyond", R.drawable.actionbar_music_normal));
//        songs.add(new Song("白玫瑰", "陈奕迅", R.drawable.actionbar_music_normal));
//        songs.add(new Song("Desperato", "Eagles", R.drawable.actionbar_music_normal));
        mInflater = LocalSongsActivity.this.getLayoutInflater();
        songs = CSApp.getLocalsongs();
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
                    CSApp.setCurrentSong(current_play);
                    txt_Songname.setText(CSApp.getCurrentSong().getSongName());
                    txt_singer.setText(CSApp.getCurrentSong().getSinger());
                }
            });
        }

        if (!CSApp.getPlayState()) {
            img_pause.setBackgroundResource(R.drawable.playbar_btn_pause);
        }
        else {
            img_pause.setBackgroundResource(R.drawable.playbar_btn_play);
        }
    }

    private void bindView() {
        list_song = (ListView) findViewById(R.id.list_song);
        ll_songlist_toolbar = (LinearLayout) findViewById(R.id.ll_songlist_toolbar);
        img_song_icon = (ImageView) findViewById(R.id.img_song_icon);
        txt_Songname = (TextView) findViewById(R.id.txt_Songname);
        txt_singer = (TextView) findViewById(R.id.txt_singer);

        img_pause = (ImageView) findViewById(R.id.img_pause);

        img_pause.setOnClickListener(this);

        CSApp = (CurrentSongApp) getApplication();
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
