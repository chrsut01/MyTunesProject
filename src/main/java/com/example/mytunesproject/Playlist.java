package com.example.mytunesproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Playlist {
    private int playlistID;
    private String playlistName;
    public String toString() { return playlistID + playlistName;}


    public Playlist(int playlistID, String playlistName){
        this.playlistID = playlistID;
        this.playlistName = playlistName;



    }
}
