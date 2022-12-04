package com.example.mytunesproject;


import java.sql.SQLException;
import java.util.List;

public interface PlaylistDao {




    public void savePlaylist(Playlist playlist); // Create a playlist

    public List<Playlist> getAllPlaylists(); // Read all playlists

    // TODO the other CRUD methods are placed here

}
