package com.example.music;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class NetFragment extends Fragment implements View.OnClickListener {

    private String content;
    private View view;
    private LinearLayout ll_song_list_1;
    public NetFragment(String content) {
        this.content = content;
    }

    private LinkedList<Song> songs_1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fg_net,container,false);
        // txt_content.setText(content);
        bindViews();
        return view;
    }

    private void bindViews() {
        ll_song_list_1 = (LinearLayout) view.findViewById (R.id.ll_song_list_1);
        ll_song_list_1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.ll_song_list_1:
                Intent intent = new Intent(getActivity(), SongListActivity.class);
                songs_1 = new LinkedList<Song>();
                songs_1.add(new Song("海阔天空", "Beyond", R.drawable.actionbar_music_normal));
                songs_1.add(new Song("白玫瑰", "陈奕迅", R.drawable.actionbar_music_normal));
                songs_1.add(new Song("Desperato", "Eagles", R.drawable.actionbar_music_normal));
                intent.putExtra("song_list", (Serializable) songs_1);
                startActivity(intent);
                break;
        }
    }
}