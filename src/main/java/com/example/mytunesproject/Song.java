package com.example.mytunesproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Song {

        private int songID;
        private String songTitle;
        private String genre;
        private String artist;

    public String toString() { return songID + songTitle + genre + artist;}

        public Song(int songID, String songTitle, String genre, String artist) {
            this.songID = songID;
            this.songTitle = songTitle;
            this.genre = genre;
            this.artist = artist;

        }
}
