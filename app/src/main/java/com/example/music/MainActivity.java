package com.example.music;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout toolbar;
    private ImageView bar_net;
    private ImageView bar_music;
    private ImageView bar_friends;

    private LinearLayout ll_tab_bar;
    private ImageView img_playlist;
    private TextView txt_Songname;
    private TextView txt_singer;
    private ImageView img_list;
    private ImageView img_pause;
    private ImageView img_next;
    private FrameLayout ly_content;

    private NetFragment fg1;
    private MusicFragment fg2;
    private FriendFragment fg3;
    private FragmentManager fm;

    private CurrentSongApp CSApp;
    private boolean FgArr;

    private void bindViews() {
        bar_net = (ImageView) findViewById(R.id.bar_net);
        bar_music = (ImageView) findViewById(R.id.bar_music);
        bar_friends = (ImageView) findViewById(R.id.bar_friends);

        ll_tab_bar = (LinearLayout) findViewById(R.id.ll_tab_bar);
        img_playlist = (ImageView) findViewById(R.id.img_playlist);
        txt_Songname = (TextView) findViewById(R.id.txt_Songname);
        txt_singer = (TextView) findViewById(R.id.txt_singer);
        img_list = (ImageView) findViewById(R.id.img_list);
        img_pause = (ImageView) findViewById(R.id.img_pause);
        img_next = (ImageView) findViewById(R.id.img_next);
        toolbar = (LinearLayout) findViewById(R.id.toolbar_menu);
        ly_content = (FrameLayout) findViewById(R.id.ly_content);

        bar_net.setOnClickListener(this);
        bar_music.setOnClickListener(this);
        bar_friends.setOnClickListener(this);
        img_pause.setOnClickListener(this);

        CSApp = (CurrentSongApp) getApplication();
        CSApp.setPlayState(true);
    }

    private void setSelected() {
        bar_net.setSelected(false);
        bar_music.setSelected(false);
        bar_friends.setSelected(false);
    }

    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(fg3 != null)fragmentTransaction.hide(fg3);
    }

    private void initLocalSongs() {
        List<Song> songs = new ArrayList<Song>();
        CSApp.setLocalsongs((List<Song>)songs);
        CSApp.addSong(new Song("Song 1", "Singer 1", R.drawable.actionbar_music_normal));
        CSApp.addSong(new Song("Song 2", "Singer 1", R.drawable.actionbar_music_normal));
        CSApp.addSong(new Song("Song 3", "Singer 1", R.drawable.actionbar_music_normal));
        CSApp.addSong(new Song("Song 4", "Singer 2", R.drawable.actionbar_music_normal));
        CSApp.addSong(new Song("Song 5", "Singer 2", R.drawable.actionbar_music_normal));
        CSApp.addSong(new Song("Song 6", "Singer 2", R.drawable.actionbar_music_normal));
        CSApp.addSong(new Song("Song 7", "Singer 3", R.drawable.actionbar_music_normal));
        CSApp.addSong(new Song("Song 8", "Singer 3", R.drawable.actionbar_music_normal));
        CSApp.addSong(new Song("Song 9", "Singer 3", R.drawable.actionbar_music_normal));
    }

    private void initSongLists() {
        ArrayList<SongList> songLists = new ArrayList<SongList>();
        CSApp.setSongLists(songLists);
        CSApp.addSongList(new SongList("Song List 1", R.drawable.actionbar_music_normal));
        CSApp.addSongList(new SongList("Song List 2", R.drawable.actionbar_music_normal));
        CSApp.addSongList(new SongList("Song List 3", R.drawable.actionbar_music_normal));
        CSApp.addSongList(new SongList("Song List 4", R.drawable.actionbar_music_normal));
        CSApp.addSongList(new SongList("Song List 5", R.drawable.actionbar_music_normal));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        bindViews();
        initLocalSongs();
        initSongLists();
        bar_net.performClick();

        if (!CSApp.getPlayState()) {
            img_pause.setBackgroundResource(R.drawable.playbar_btn_pause);
        }
        else {
            img_pause.setBackgroundResource(R.drawable.playbar_btn_play);
        }

        //??????????????????
        // toolbar.setNavigationIcon(R.drawable.ab_android);
        //????????????
        //toolbar.inflateMenu(R.menu.menu_main);
        //???????????????
//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                return true;
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fTransaction = fm.beginTransaction();

        switch (v.getId()) {
            case R.id.bar_net:
                hideAllFragment(fTransaction);
                setSelected();
                bar_net.setSelected(true);
                if (fg1 == null) {
                    fg1 = new NetFragment("First Fragment");
                    fTransaction.add(R.id.ly_content, fg1);
                }
                else {
                    fTransaction.show(fg1);
                }
                break;
            case R.id.bar_music:
                hideAllFragment(fTransaction);
                setSelected();
                bar_music.setSelected(true);
                if (fg2 == null) {
                    fg2 = new MusicFragment("Song Lists");
                    fTransaction.add(R.id.ly_content, fg2);
                }
                else {
                    fTransaction.show(fg2);
                }
                break;
            case R.id.bar_friends:
                hideAllFragment(fTransaction);
                setSelected();
                bar_friends.setSelected(true);
                if (fg3 == null) {
                    fg3 = new FriendFragment("Third Fragment");
                    fTransaction.add(R.id.ly_content, fg3);
                }
                else {
                    fTransaction.show(fg3);
                }
                break;
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
        fTransaction.commit();
    }

    @Override
    public void onResume() {

        super.onResume();
        if (!CSApp.getPlayState()) {
            img_pause.setBackgroundResource(R.drawable.playbar_btn_pause);
        }
        else {
            img_pause.setBackgroundResource(R.drawable.playbar_btn_play);
        }

        if (CSApp.getCurrentSong() != null) {
            txt_Songname.setText(CSApp.getCurrentSong().getSongName());
            txt_singer.setText(CSApp.getCurrentSong().getSinger());
        }

    }

}
