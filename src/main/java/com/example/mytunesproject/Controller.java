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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.*;


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
    private ComboBox<String> genreDropDown;
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
    private ListView<Playlist> playlistLV;
    @FXML
    private ListView<Song> songLV;
    @FXML
    private ListView<Song> soP;



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

    private final ObservableList<String> genre = FXCollections.observableArrayList("Pop", "Rock", "Metal",
            "Classical", "Jazz", "Folk", "Arena Rock", "R&B", "Hip Hop", "Afrobeats", "Dance");
     ComboBox comboBox = new ComboBox(genre);
    public ComboBox<String> Genre() {
        genre.addAll();
        return genreDropDown()
                ;
    }






    @FXML
    public void initialize() {
        System.out.println(songDao.getAllSongs());
        List<Song> songs = songDao.getAllSongs();
            for (Song song : songs) {
                //songLV.getItems().add(song);  /*  *** THIS IS WHAT IS STOPPING DIALOG BOXES ****  */
                //String title = song.getSongTitle();
                //soP.getItems().add(String.valueOf(time));
                }

            System.out.println(playlistDao.getAllPlaylists());
            List<Playlist> playlists = playlistDao.getAllPlaylists();
                for (Playlist playlist : playlists) {
                    //playlistLV.getItems().add(playlist);   /*  *** THIS IS WHAT IS STOPPING DIALOG BOXES ****  */
                    //String name = playlist.getPlaylistName();
                }

        }

    @FXML
    void addSongPlaylist(ActionEvent event) {
        List<Playlist> playlists = playlistDao.getAllPlaylists();
        List<Song> songs = songDao.getAllSongs();
        for (Playlist playlist : playlists) {
            soP.getItems().add((Song) song);
        }

    }


    @FXML
    void deletSongLib(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Delete song");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        Label confirm = new Label("Are you sure you want to continue?");
        dialog.getDialogPane().setContent(confirm);
        Optional<ButtonType> button = dialog.showAndWait();

        // Her afsluttes dialogen med at man kan trykke på OK
        // Derefter kan vi henter felternes indhold ud og gøre hvad der skal gøres...
        // **** CAN REMOVE SONG FROM songLV BUT NOT FROM DATABASE ****
        if (button.get() == ButtonType.OK)
            try {
                ObservableList<Integer> chosenIndex = songLV.getSelectionModel().getSelectedIndices();
                if (chosenIndex.size() == 0)
                    System.out.println("Choose a song");
                else
                    for (Object index : chosenIndex) {
                        System.out.println("You chose " + songLV.getSelectionModel().getSelectedItem());
                        Song s = (Song) songLV.getItems().get((int) index);
                        songLV.getItems().remove(songLV.getSelectionModel().getSelectedItem());
                        //sdi.sletSang(s.getSongID());
                        songDao.deleteSong(s);

                    }

            }catch (Exception e) {
                System.out.println("Something went wrong");
            }

    }

    @FXML
    void deleteSongfromPlayList(ActionEvent event) {

    }

    @FXML
    void deletePlayList(ActionEvent event) {
        playlistLV.getItems().remove(playlistLV.getSelectionModel().getSelectedItem());

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
    /*    try {
            //Song song = new Song(Integer.parseInt(""), + insertTitle.getText(), + insertArtist.getText(),
            // + insertTime.getText());          + insertFile.getText() + ;
            //songLV.getItems().add(song);
            songLV.scrollTo(songLV.getItems().size() - 1);

            //Vare vare = new Vare(Integer.parseInt(varenrInput.getText()), " " + vareBeskrivInput.getText());
            //vareNrBeskriv.getItems().add(vare);
            //vareNrBeskriv.scrollTo(vareNrBeskriv.getItems().size() - 1);

        } catch (Exception e) {
            System.out.println("Noget gik galt, tjek om der er insat et valid nr");
        }
        insertTitle.clear();
        insertArtist.clear();
        insertTime.clear();
        insertFile.clear();  */
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
    void closeProgram(ActionEvent event) {
        stage = (Stage) programPane.getScene().getWindow();
        stage.close();
    }


}
