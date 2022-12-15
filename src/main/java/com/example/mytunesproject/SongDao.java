package com.example.mytunesproject;


import java.sql.SQLException;
import java.util.List;

public interface SongDao {


        public void saveSong(String title, String artist, String genre, int time, String file); // Create a song

        public List<Song> getAllSongs(); // Read all songs

        public void updateSong(Song song);
        public void deleteSong(Song song);


}
