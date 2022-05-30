package com.example.music;

import java.io.Serializable;

public class Song implements Serializable {
    private String SongName;
    private String Singer;
    private int Icon;

    public Song(String SongName, String Singer, int Icon) {
        this.Singer = Singer;
        this.SongName = SongName;
        this.Icon = Icon;
    }

    public String getSongName() {
        return SongName;
    }

    public String getSinger() {
        return Singer;
    }

    public int getIcon() { return Icon; }

    public void setSongName(String SongName) {
        this.SongName = SongName;
    }

    public void setSinger(String Singer) {
        this.Singer = Singer;
    }

    public void setIcon(int Icon) { this.Icon = Icon; }
}
