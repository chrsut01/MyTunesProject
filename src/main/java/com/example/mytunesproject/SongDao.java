package com.example.mytunesproject;


import java.sql.SQLException;
import java.util.List;

public interface SongDao {


        public void saveSong(Song song); // Create a song

        public List<Song> getAllSongs(); // Read all songs

       // public void savePlaylist(Playlist playlist); // Create a playlist

        //public List<Playlist> getAllPlaylists(); // Read all playlists

        // TODO the other CRUD methods are placed here

}
