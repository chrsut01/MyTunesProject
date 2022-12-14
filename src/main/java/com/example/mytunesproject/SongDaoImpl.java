package com.example.mytunesproject;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongDaoImpl implements SongDao{


    private Connection con; // forbindelsen til databasen

    public SongDaoImpl() {
        try { con = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-F11OIRMM:1433;databaseName=Mytunes;userName=sa;password=123456;encrypt=true;trustServerCertificate=true");
        } catch (SQLException e) {
            System.err.println("cannot create connection" + e.getMessage());
        }

        System.out.println("SongDaoImpl connected to the database... ");
    }

    public void saveSong(String title, String artist, String genre, int time, String file) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO SONG VALUES(?,?,?,?,?);");
            ps.setString(1, title);
            ps.setString(2, artist);
            ps.setString(3, genre);
            ps.setInt(4, time);
            ps.setString(5, file);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("cannot insert record (saveSong)");
        }
    }

    public List<Song> getAllSongs() {
        List<Song> songs = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Song;");
            ResultSet rs = ps.executeQuery();

            Song song;
            while (rs.next()) {
                int songID = rs.getInt(1);
                String songTitle = rs.getString(2);
                String  genre = rs.getString(3);
                String artist = rs.getString(4);
                int songTime = rs.getInt(5);
                String songFile = rs.getString(6);

                song = new Song(songID, songTitle, genre, artist, songTime, songFile);
                songs.add(song);

            }

        } catch (SQLException e) {
            System.err.println("cannot access records (SongDaoImpl)");
        }
        return songs;

    }

    @Override
    public void updateSong(Song song) {

    }

    @Override
    public void deleteSong(Song song) {

            System.out.println("deleting:"+ song.getSongID());
            try {
                PreparedStatement pso = con.prepareStatement("DELETE CASCADE FROM Song WHERE songID = ?");
                pso.setInt(1, (song.getSongID()));
                //PreparedStatement pp = con.prepareStatement("DELETE FROM Playlist WHERE songID = ?");
                //pp.setInt(1, (song.getSongID()));
                //PreparedStatement ps = con.prepareStatement("DELETE FROM Song WHERE songID = ?");
                //ps.setInt(1, (song.getSongID()));

                //ps.setString(1, String.valueOf(song.getSongID()));
                //ps.setString(2, song.getSongTitle());
                //ps.setString(3, song.getGenre());
                //ps.setString(4, song.getArtist());
                //ps.setInt(5, song.getSongTime());

                pso.executeUpdate();

            } catch (SQLException e) {
                System.err.println("Cannot delete song");
            }
        }



   /* @Override
    public void deleteSong(Song song) {
        songs.remove(song.getClass());
    }*/

    // @Override
   // public void savePlaylist(Playlist playlist) {
    //}

    //@Override
    //public List<Playlist> getAllPlaylists() { return null;}
}
