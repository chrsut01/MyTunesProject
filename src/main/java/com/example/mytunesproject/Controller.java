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

import java.io.IOException;


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

    /*  // Dialogen defineres med "ButtonTyes", hvilket betyder at vi kan bestemmer at
        // dialogen afsluttes med at vi tester på knapperne
        Dialog<ButtonType> dialog = new Dialog();

        // Her sættes vinduet op
        dialog.setTitle("Eksempel på dialog");
        dialog.setHeaderText("Her kan stå noget tekst");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        TextField felt1 = new TextField();
        TextField felt2 = new TextField();
        VBox box = new VBox(felt1, felt2);
        dialog.getDialogPane().setContent(box);
         // Her afsluttes dialogen med at man kan trykke på OK
        Optional<ButtonType> knap = dialog.showAndWait();
        // Derefter kan vi henter felternes indhold ud og gøre hvad der skal gøres...
        if (knap.get() == ButtonType.OK)
            System.out.println("Felt1 = " + felt1.getText() + " felt2 = " + felt2.getText());
    }*/

    @FXML
    void newPlayList(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("NewEditPlaylist.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    void editPlayList(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("NewEditPlaylist.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }
    @FXML
    void deletePlayList(ActionEvent event) {    }

    @FXML
    void newSongLib(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("NewEditSong.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    void editSongLib(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("NewEditSong.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
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
