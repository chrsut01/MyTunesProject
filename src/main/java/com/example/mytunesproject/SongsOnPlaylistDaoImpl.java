package com.example.mytunesproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SongsOnPlaylistDaoImpl implements SongsOnPlaylistDao {


    private Connection con; // forbindelsen til databasen

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

    public void deleteSongPL(int playlistID, int songID) {

    }


}