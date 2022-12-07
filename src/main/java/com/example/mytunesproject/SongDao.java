package com.example.mytunesproject;


import java.sql.SQLException;
import java.util.List;

public interface SongDao {


        void saveSong(Song song); // Create a song

        List<Song> getAllSongs(); // Read all songs

        void updateSong(Song song);
        void deleteSong(Song song);

       // public void savePlaylist(Playlist playlist); // Create a playlist

        //public List<Playlist> getAllPlaylists(); // Read all playlists

        // TODO the other CRUD methods are placed here

}
