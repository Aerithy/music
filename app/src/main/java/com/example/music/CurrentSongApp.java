package com.example.music;

import android.app.Application;

import java.util.LinkedList;

public class CurrentSongApp extends Application {
    private Song CurrentSong;
    private Song NextSong;
    private boolean PlayState;
    private LinkedList<Song> CurrentPlayList;

    public Song getCurrentSong () {
        return CurrentSong;
    }

    public Song getNextSong () {
        return NextSong;
    }

    public boolean getPlayState () {
        return PlayState;
    }

    public LinkedList<Song> getCurrentPlayList() {
        return CurrentPlayList;
    }

    public void setCurrentSong (Song currentSong) {
        this.CurrentSong = currentSong;
    }

    public void setNextSong (Song nextSong) {
        this.NextSong = nextSong;
    }

    public void setPlayState (boolean playState) {
        this.PlayState = playState;
    }

    public void setCurrentPlayList (LinkedList<Song> currentPlayList) {
        this.CurrentPlayList = currentPlayList;
    }
}
