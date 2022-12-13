package com.example.mytunesproject;

import java.sql.Connection;
import java.sql.DriverManager;
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

}