package com.example.mytunesproject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongsOnPlaylistDaoImpl implements SongsOnPlaylistDao {


    private Connection con; // CONNECTS TO DATABASE

    public SongsOnPlaylistDaoImpl() {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-F11OIRMM:1433;databaseName=Mytunes;userName=sa;password=123456;encrypt=true;trustServerCertificate=true");
        } catch (SQLException e) {
            System.err.println("cannot create connection (SongsOnPlaylistDaoImpl)" + e.getMessage());
        }

        System.out.println("SongsOnPlaylistDaoImpl connected to the database... ");
    }

    public void addSongPL(int playlistID, int songID) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO SongsOnPLaylist VALUES(?,?);");
            ps.setInt(1, playlistID);
            ps.setInt(2, songID);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("cannot insert record (saveSong)");
        }
    }

     public void deleteSongPL(Song song) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM SongsOnPlaylist WHERE songID = ?;");
            ps.setInt(1, (song.getSongID()));

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Cannot delete song");
        }
    }

    @Override
    public List<Song> getAllSongsOnPlaylist(Playlist playlist) {
            List<Song> songsOnPlaylist = new ArrayList<>();
            try {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM Song, Playlist, SongsOnPlaylist WHERE " +
                        "Playlist.playlistID = SongsOnPlaylist.playlistID AND SongsOnPlaylist.songID = Song.songID AND " +
                        "Playlist.playlistID = ?;");
                ps.setInt(1, playlist.getPlaylistID());
                ResultSet rs = ps.executeQuery();
                Song song;
                while (rs.next()) {
                    int songID = rs.getInt(1);
                    String songTitle = rs.getString(2);
                    String  genre = rs.getString(3);
                    String artist = rs.getString(4);
                    int songTime = rs.getInt(5);
                    String songFile = rs.getString(6);

                    song = new Song(songID, songTitle, artist,  genre,  songTime,  songFile);
                    songsOnPlaylist.add(song);
                }

            } catch (SQLException e) {
                System.err.println("cannot access records (SongDaoImpl)");
            }
            return songsOnPlaylist;
    }
}