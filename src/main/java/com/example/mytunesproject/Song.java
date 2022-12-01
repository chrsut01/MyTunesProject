package com.example.mytunesproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Song {

        private int songID;
        private String songTitle;
        private String genre;
        private String artist;
        private int songTime;
    public String toString() { return songID + songTitle + genre + artist + songTime;}

        public Song(int songID, String songTitle, String genre, String artist, int songTime) {
            this.songID = songID;
            this.songTitle = songTitle;
            this.genre = genre;
            this.artist = artist;
            this.songTime = songTime;

        }

    public int getSongID() { return this.songID;
    }

    public String getSongTitle() {  return this.songTitle;
    }

    public String getGenre() { return this.genre;
    }

    public String getArtist() {  return this.artist;
    }

    public int getSongTime() {  return this.songTime;
    }
}
