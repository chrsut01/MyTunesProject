package com.example.mytunesproject;

import java.util.List;

public interface SongsOnPlaylistDao {

    public void addSongPL(int playlistID, int songID);

    public void deleteSongPL(Song song);

    List<Song> getAllSongsOnPlaylist(Playlist playlist);

  }
