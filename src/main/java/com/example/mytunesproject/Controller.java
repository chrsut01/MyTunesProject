package com.example.mytunesproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;

import java.io.IOException;
import java.util.Objects;


public class Controller {
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
    private TextField filterField;
    @FXML
    private TextField songIsPlaying;
    @FXML
    private Slider volumeControl;
    @FXML
    private TextField playlistName;

    @FXML
    void addSongPlaylist(ActionEvent event) {

    }

    @FXML
    void closeProgram(ActionEvent event) {

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
        newSongStage.showAndWait();
    }



    @FXML
    void editPlayList(ActionEvent event) throws IOException {
        Parent mainWindowParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NewEditPlaylist.fxml")));
        Scene mainWindowScene = new Scene(mainWindowParent);
        Stage newSongStage = new Stage();
        newSongStage.setScene(mainWindowScene);
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
        newSongStage.showAndWait();
    }


   

    @FXML
    void editSongLib(ActionEvent event) throws IOException{
        Parent mainWindowParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NewEditSong.fxml")));
        Scene mainWindowScene = new Scene(mainWindowParent);
        Stage newSongStage = new Stage();
        newSongStage.setScene(mainWindowScene);
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
    void cancelEdit(ActionEvent event) {

    }

    @FXML
    void saveEdit(ActionEvent event) {

    }


}
