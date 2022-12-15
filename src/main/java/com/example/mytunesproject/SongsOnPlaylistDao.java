package com.example.mytunesproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.util.List;

public interface SongsOnPlaylistDao {

    public void addSongPL(int playlistID, int songID);

    public void deleteSongPL(Song song);

    List<Song> getAllSongsOnPlaylist(Playlist playlist);

    List<Song> getAllSongs();


    //public void moveDown(ActionEvent event) {
    //}

    //public void moveUp(ActionEvent event) {
    //}
}
