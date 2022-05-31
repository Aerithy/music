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

public class SongListActivity extends BaseActivity implements View.OnClickListener{

    private List<Song> songs = null;
    private SongAdapter songAdapter = null;
    private int Icon;

    private LinearLayout ll_songlist_toolbar;
    private ListView list_song;
    private LayoutInflater mInflater;
    private ImageView img_songlist_icon;
    private TextView txt_songlist_intro;
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
        mInflater = SongListActivity.this.getLayoutInflater();
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

        img_songlist_icon.setBackgroundResource(Icon);
    }

    private void bindView() {
        list_song = (ListView) findViewById(R.id.list_song);
        ll_songlist_toolbar = (LinearLayout) findViewById(R.id.ll_songlist_toolbar);
        img_songlist_icon = (ImageView) findViewById(R.id.img_songlist_icon);
        txt_songlist_intro = (TextView) findViewById(R.id.txt_songlist_intro);

    }

    @Override
    public void onClick(View v) {

    }
}
