package com.example.mytunesproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    private final TableView<Object> Playlists = new TableView<>();

    @FXML
    private final TableView<Object> Songs = new TableView<>();

    @FXML
    private ListView<Object> SoP = new ListView<>();


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

    //private static final String DEFAULT_QUERY = "SELECT FROM Songs";




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
       // System.out.println();
    }

    /*
     private void showWindow(String message) throws IOException {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("Dialog.fxml"));
        loader.setController(new DialogController(message));
        // Root loades og den nye stage tilføjes
        final Parent root = loader.load();
        final Scene scene = new Scene(root, 250, 150);
        Stage stage = new Stage();
        // Stage sættes modal, så vinduet skal besvares
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initOwner(emailField.getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }*/



/*
    stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initOwner(emailField.getScene().getWindow());
        stage.setScene(scene);
        stage.show();
  */


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
