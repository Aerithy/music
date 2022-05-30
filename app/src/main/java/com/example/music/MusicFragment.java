package com.example.music;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MusicFragment extends Fragment {

    private String content;
    private List<SongList> songLists = null;
    private SongListAdapter songListAdapter = null;
    private ListView list_songlist;
    private LayoutInflater mInflater;

    public MusicFragment(String content) {

        this.content = content;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        songLists = new ArrayList<>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_music,container,false);
        TextView txt_content = (TextView) view.findViewById(R.id.txt_songlist);
        list_songlist = (ListView) view.findViewById(R.id.list_songlist);
        songLists = new LinkedList<SongList>();
        SongList songList = new SongList(content, R.drawable.actionbar_music_normal);
        songLists.add(songList);
        songLists.add(new SongList("Waiting in the weeds", R.drawable.actionbar_music_normal));
        songLists.add(new SongList("Love will keep us alive", R.drawable.actionbar_music_normal));
        mInflater = getActivity().getLayoutInflater();
        songListAdapter = new SongListAdapter((LinkedList<SongList>) songLists, mInflater);
        list_songlist.setAdapter(songListAdapter);
        txt_content.setText(content);
        return view;
    }
}
