package com.example.music;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.LinkedList;

public class SongAdapter extends BaseAdapter {

    private ArrayList<Song> songs;
    private LayoutInflater mInflater;

    public SongAdapter(ArrayList<Song> songs, LayoutInflater mInflater) {
        this.songs = songs;
        this.mInflater = mInflater;
    }

    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = mInflater.inflate(R.layout.song_item_list, null);
        ImageView img_song_icon = (ImageView) convertView.findViewById(R.id.img_song_icon);
        ImageView img = (ImageView) convertView.findViewById(R.id.img_add_song);
        TextView txt_song_name = (TextView) convertView.findViewById(R.id.txt_song_name);
        TextView txt_song_singer = (TextView) convertView.findViewById(R.id.txt_song_singer);


        img_song_icon.setBackgroundResource(songs.get(position).getIcon());
        txt_song_name.setText(songs.get(position).getSongName());
        txt_song_singer.setText(songs.get(position).getSinger());

        return convertView;
    }
}
