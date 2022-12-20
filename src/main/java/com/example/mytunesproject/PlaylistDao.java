package com.example.mytunesproject;


import java.util.List;

public interface PlaylistDao {

    public void savePlaylist(String playlistName);
    public void deletePlaylist(Playlist playlist);


    public List<Playlist> getAllPlaylists(); // Read all playlists

    // TODO the other CRUD methods are placed here

}
