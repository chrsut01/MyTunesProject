package com.example.mytunesproject;

public class Song {

        private int songID;
        private String songTitle;
        private String artist;
        private String genre;
        private int songTime;
    public String toString() { return songTitle + "          " + artist + "          " + genre + "          " + songTime;}

        public Song(int songID, String songTitle, String artist, String genre, int songTime) {
            this.songID = songID;
            this.songTitle = songTitle;
            this.artist = artist;
            this.genre = genre;
            this.songTime = songTime;
        }

    public int getSongID() { return this.songID;
    }
    public int setSongID() {
        return songID;
    }

    public String getSongTitle() { return this.songTitle;
    }
    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }
    public String getGenre() { return this.genre;
    }

    public String getArtist() { return this.artist;
    }

    public int getSongTime() { return this.songTime;
    }
}
