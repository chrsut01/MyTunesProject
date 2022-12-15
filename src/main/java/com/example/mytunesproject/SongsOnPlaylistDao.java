package com.example.mytunesproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.util.List;

public interface SongsOnPlaylistDao {

    public void addSongPL(int playlistID, int songID);

    public void deleteSongPL(int playlistID, int songID);


    //public void moveDown(ActionEvent event) {
    //}

    //public void moveUp(ActionEvent event) {
    //}
}
