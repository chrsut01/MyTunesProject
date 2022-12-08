package com.example.mytunesproject;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;


public class Controller /*implements Initializable*/ {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField insertArtist;
    @FXML
    private TextField insertFile;
    @FXML
    private TextField insertTime;
    @FXML
    private TextField insertTitle;
    @FXML
    private Pane programPane;
    @FXML
    private Pane newEditSong;
    @FXML
    private Pane newEditPlaylist;

    @FXML
    private TextField filterField;
    @FXML
    private TextField songIsPlaying;
    @FXML
    private Slider volumeControl;
    @FXML
    private TextField playlistName;



    @FXML
    private ListView<String> playlistLV;
    @FXML
    private ListView<String> songLV;
    @FXML
    private ListView<String> soP;



    private SongDao songDao = new SongDaoImpl(); //SongDao reference variabel
    private PlaylistDao playlistDao = new PlaylistDaoImpl();

    //@FXML

//TableView<MyModel> tableView;
    public void MyController() {
             }



    //Def. af listen der holder dataene
    private final ObservableList<Song> song = FXCollections.observableArrayList();
    private ObservableList<Song> loadAllSongs() {
        ObservableList<Song> songs = FXCollections.observableArrayList(); //Lav en tom observableList
        songDao = new SongDaoImpl(); //Opret songDao objekt
        songs.addAll(songDao.getAllSongs()); //tilfÃ¸j alle sange til variabel.

        return songs;
    }


        @FXML
        public void initialize() {

            System.out.println(songDao.getAllSongs());
            List<Song> songs = songDao.getAllSongs();

            for (Song song : songs) {
                String title = song.getSongTitle();
                //int time = song.getSongTime();
                //String artist = song.getArtist();
                //String songInfo = song.getSongTitle();

                songLV.getItems().add(song.toString());
                //soP.getItems().add(String.valueOf(time));
            }

                System.out.println(playlistDao.getAllPlaylists());
                List<Playlist> playlists = playlistDao.getAllPlaylists();

                for (Playlist playlist : playlists) {
                    String name = playlist.getPlaylistName();
                    playlistLV.getItems().add(name);
                }

        }



    @FXML
    void addSongPlaylist(ActionEvent event) {

    }


    @FXML
    void deletSongLib(ActionEvent event) {

    }

    @FXML
    void deleteSongfromPlayList(ActionEvent event) {

    }

    @FXML
    void newPlayList(ActionEvent event) throws IOException{
        Parent mainWindowParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NewEditPlaylist.fxml")));
        Scene mainWindowScene = new Scene(mainWindowParent);
        Stage newSongStage = new Stage();
        newSongStage.setScene(mainWindowScene);
        newSongStage.initModality(Modality.APPLICATION_MODAL);
        newSongStage.showAndWait();
    }



    @FXML
    void editPlayList(ActionEvent event) throws IOException {
        Parent mainWindowParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NewEditPlaylist.fxml")));
        Scene mainWindowScene = new Scene(mainWindowParent);
        Stage newSongStage = new Stage();
        newSongStage.setScene(mainWindowScene);
        newSongStage.initModality(Modality.APPLICATION_MODAL);
        newSongStage.showAndWait();
    }


    @FXML
    void deletePlayList(ActionEvent event) {    }



   @FXML
    void newSongLib(ActionEvent event) throws IOException {
       Parent mainWindowParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NewEditSong.fxml")));
       Scene mainWindowScene = new Scene(mainWindowParent);
       Stage newSongStage = new Stage();
       newSongStage.setScene(mainWindowScene);
       newSongStage.initModality(Modality.APPLICATION_MODAL);
       newSongStage.showAndWait();
    }




    @FXML
    void editSongLib(ActionEvent event) throws IOException{
        Parent mainWindowParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NewEditSong.fxml")));
        Scene mainWindowScene = new Scene(mainWindowParent);
        Stage newSongStage = new Stage();
        newSongStage.setScene(mainWindowScene);
        newSongStage.initModality(Modality.APPLICATION_MODAL);
        newSongStage.showAndWait();
    }


    @FXML
    void forward(ActionEvent event) {

    }

    @FXML
    void moveDown(ActionEvent event) {

    }

    @FXML
    void moveUp(ActionEvent event) {

    }

    @FXML
    void play(ActionEvent event) {

    }

    @FXML
    void previous(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

    }


    @FXML
    void cancelSongInfo(ActionEvent event) {
        insertTitle.clear();
        insertArtist.clear();
        insertTime.clear();
        insertFile.clear();
        stage = (Stage) newEditSong.getScene().getWindow();
        stage.close();
    }

    @FXML
    void chooseFile(ActionEvent event) {

    }

    @FXML
    void moreGenre(ActionEvent event) {

    }

    @FXML
    void saveSongInfo(ActionEvent event) {

    }

    @FXML
    void cancelEditPlaylist(ActionEvent event) {
        playlistName.clear();
        stage = (Stage) newEditPlaylist.getScene().getWindow();
        stage.close();
    }


    @FXML
    void saveEditPlaylist(ActionEvent event) {

    }
    @FXML
    void closeProgram(ActionEvent event) {
        stage = (Stage) programPane.getScene().getWindow();
        stage.close();
    }

   /* @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }*/


   /* @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }*/
}
