package com.example.mytunesproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Collection;

public class Playlist {
    private int playlistID;
    private String playlistName;


    public String toString() { return playlistName;}


    public Playlist(int playlistID, String playlistName){
        this.playlistID = playlistID;
        this.playlistName = playlistName;
    }

    public int getPlaylistID() { return playlistID; }

    public String getPlaylistName() { return playlistName;  }
}
