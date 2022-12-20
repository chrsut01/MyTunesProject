package com.example.mytunesproject;

public class Playlist {
    private int playlistID;
    private String playlistName;


    public String toString() { return playlistName;}


    public Playlist(int playlistID, String playlistName){
        this.playlistID = playlistID;
        this.playlistName = playlistName;
    }
    public Playlist() {
    }

    public int getPlaylistID() { return playlistID; }

    public String getPlaylistName() { return playlistName;  }
}
