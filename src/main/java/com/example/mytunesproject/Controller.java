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
    private TableView<Playlist> tbPlaylists;

    @FXML
    private TableView<Song> tbSongs;


    // Def. af kolonnerne
       @FXML
    private TableColumn<Song, String> tblClmnSongTitle = new TableColumn<>();

    @FXML
    private TableColumn<Song, String>  tblClmnSongArtist = new TableColumn<>();

    @FXML
    private TableColumn<Song, String>  tblClmnSongGenre = new TableColumn<>();

    @FXML
    private TableColumn<Song, Integer> tblClmnSongTime = new TableColumn<Song, Integer>();


    @FXML
    private ListView<SongsOnPlaylist> soP;



   private SongDaoImpl songDao; //SongDao reference variabel
    //@FXML

//TableView<MyModel> tableView;
    public void MyController() {
             }


  /*@Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        tblClmnSongTitle.setCellValueFactory(new PropertyValueFactory<>("songTitle"));
        tblClmnSongArtist.setCellValueFactory(new PropertyValueFactory<Song, String>("Artist"));
        tblClmnSongGenre.setCellValueFactory(new PropertyValueFactory<Song, String>("Genre"));
        tblClmnSongTime.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSongTime()));

        initSongTable();
    }*/


    // Def. af listen der holder dataene
 /*   private final ObservableList<Song> song = FXCollections.observableArrayList();
    private ObservableList<Song> loadAllSongs() {
        ObservableList<Song> songs = FXCollections.observableArrayList(); //Lav en tom observableList
        songDao = new SongDaoImpl(); //Opret songDao objekt
        songs.addAll(songDao.getAllSongs()); //tilfÃ¸j alle sange til variabel.

        return songs;
    }*/

   /*private void initSongTable(){
        //tblClmnSongTitle.setCellValueFactory(new PropertyValueFactory<>("songTitle"));
        //Song.setItems(songDao.getAllSongs());
        tblClmnSongTitle.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getSongTitle()));
        tblClmnSongArtist.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getArtist()));
        tblClmnSongGenre.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getGenre()));
        tblClmnSongTime.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getSongTime()));

        songs.setItems(loadAllSongs());
   }*/
       /* @FXML
        public void initialize() {
            SongDaoImpl songDao = new SongDaoImpl.getAllSongs();
           // .getItems().addAll(getDataFromSource()); // Perfectly Ok here, as FXMLLoader already populated all @FXML annotated members.
        }*/


    /* //FROM ERIK ON TUESDAY:
    private final ObservableList<Song> song = FXCollections.observableArrayList();
    public void initialize() {
        // Kolonnerne sættes op med forbindelse til klassen Song med hver sit felt
        tblClmnSongTitle.setCellValueFactory(new PropertyValueFactory<Song, String>("songTitle"));
        tblClmnSongArtist.setCellValueFactory(new PropertyValueFactory<Song, String>("Artist"));
        tblClmnSongGenre.setCellValueFactory(new PropertyValueFactory<Song, String>("Genre"));
        tblClmnSongTime.setCellValueFactory(new PropertyValueFactory<Song, Integer>("songTime"));

        // Data lægges i listen som objekterne af klassen Person
        song.add(new Song(3,"Crazy Train", "Ozzy", "Rock", 333));
        song.add(new Song(4,"Jingle Bells", "Cash", "Julesang", 222));
        song.add(new Song(5,"Smooth C.", "MJ", "plop", 444));
        song.add(new Song(6,"Memories", "Patty Lapone", "musical", 550));

        // Data lægges over i tabellen
        tbSongs.setItems(song);
    }*/



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
