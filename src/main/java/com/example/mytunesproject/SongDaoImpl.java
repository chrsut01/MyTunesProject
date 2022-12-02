package com.example.mytunesproject;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongDaoImpl {


    private Connection con; // forbindelsen til databasen

    public SongDaoImpl() {
        try {

            con = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-F11OIRMM:1433;databaseName=Mytunes;userName=sa;password=123456;encrypt=true;trustServerCertificate=true");
        } catch (SQLException e) {
            System.err.println("can not create connection" + e.getMessage());
        }

        System.out.println("connected to the database... ");
    }

    public void saveBook(Song song) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO SONG VALUES(?,?,?,?,?);");
            ps.setInt(1, song.getSongID());
            ps.setString(2, song.getSongTitle());
            ps.setString(3, song.getGenre());
            ps.setString(4, song.getArtist());
            ps.setInt(5, song.getSongTime());


            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("can not insert record");
        }
    }

    public List<Song> getAllSongs() {
        List<Song> songs = new ArrayList();
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

                song = new Song(songID, songTitle, genre, artist, songTime);
                songs.add(song);
            }

        } catch (SQLException e) {
            System.err.println("can not access records");
        }
        return songs;
    }

   // @Override
   // public void savePlaylist(Playlist playlist) {
    //}

    //@Override
    //public List<Playlist> getAllPlaylists() { return null;}
}
