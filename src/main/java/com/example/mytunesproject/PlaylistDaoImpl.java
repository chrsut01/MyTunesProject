package com.example.mytunesproject;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDaoImpl implements PlaylistDao {

    private Connection con; // CONNECTS TO DATABASE

    public PlaylistDaoImpl() {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-F11OIRMM:1433;databaseName=Mytunes;userName=sa;password=123456;encrypt=true;trustServerCertificate=true");
        } catch (SQLException e) {
            System.err.println("cannot create connection (PlaylistDaoImpl)" + e.getMessage());
        }

        System.out.println("PlaylistDaoImpl connected to the database... ");
    }

    public void savePlaylist(String playlistName) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO PLAYLIST VALUES(?);");
            ps.setString(1, playlistName);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("cannot insert record: " + e.getMessage());
        }
    }

    public void deletePlaylist(Playlist playlist) {
        try {
            PreparedStatement pr = con.prepareStatement("DELETE FROM SongsOnPlaylist WHERE playlistID = ?;");
            pr.setInt(1, (playlist.getPlaylistID()));
            pr.executeUpdate();

            PreparedStatement ps = con.prepareStatement("DELETE FROM Playlist WHERE playlistID = ?;");
            ps.setInt(1, (playlist.getPlaylistID()));
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("cannot delete playlist");
        }
    }

    public List<Playlist> getAllPlaylists() {
        List<Playlist> playlists = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Playlist;");
            ResultSet rs = ps.executeQuery();

            Playlist playlist;
            while (rs.next()) {
                int playlistID = rs.getInt(1);
                String playlistName = rs.getString(2);

                playlist = new Playlist(playlistID, playlistName);
                playlists.add(playlist);
            }

        } catch (SQLException e) {
            System.err.println("cannot access records (PlaylistDaoImpl)");

            }
        return playlists;
    }
}
