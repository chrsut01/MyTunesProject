package com.example.mytunesproject;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


public class Controller {
    private Stage stage;


   @FXML
    private Pane programPane;

   // DID NOT MANAGE TO IMPLEMENT
   @FXML
    private TextField filterField;
    @FXML
    private TextField songIsPlaying;

   // DID NOT MANAGE TO IMPLEMENT
    @FXML
    private Slider volumeControl;

    @FXML
    private ListView<Playlist> playlistLV;
    @FXML
    private ListView<Song> songLV;
    @FXML
    private ListView<Song> soP;

    private boolean afspiller = false;

    private SongDao songDao = new SongDaoImpl();
    private PlaylistDao playlistDao = new PlaylistDaoImpl();
    private SongsOnPlaylistDao songsOnPlaylistDao = new SongsOnPlaylistDaoImpl();

    @FXML
    public void initialize() {
        refreshSongLV();
        refreshPlaylistLV();
    }

    // UPLOADS SONGS TO SONG LISTVIEW FROM START OF PROGRAM
    private void refreshSongLV() {
        songLV.getItems().clear();
        System.out.println(songDao.getAllSongs());
        List<Song> songs = songDao.getAllSongs();
        for (Song song : songs) {
            songLV.getItems().add(song);
        }
    }

    // UPLOADS PLAYLISTS TO PLAYLIST LISTVIEW FROM START OF PROGRAM
    private void refreshPlaylistLV() {
        playlistLV.getItems().clear();
        System.out.println(playlistDao.getAllPlaylists());
        List<Playlist> playlists = playlistDao.getAllPlaylists();
        for (Playlist playlist : playlists) {
            playlistLV.getItems().add(playlist);
        }
    }
   //ADDS A NEW SONG TO SONG DATABASE
    @FXML
    void newSongLib(ActionEvent event) throws IOException {
        Dialog<ButtonType> dialog = new Dialog<>();

        dialog.setTitle("new song dialog");
        dialog.setHeaderText("Add a new Song");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        TextField titleTF = new TextField();
        TextField artistTF = new TextField();
        TextField genreTF = new TextField();
        TextField timeTF = new TextField();
        TextField fileTF = new TextField();
        Button chooseFileButton = new Button("Choose");

        chooseFileButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select file resource");
            fileChooser.getExtensionFilters().addAll();
            new FileChooser.ExtensionFilter("MP3 File", ".mp3");
            new FileChooser.ExtensionFilter("WAV File", ".wav");
            Node source = (Node) e.getSource();
            File file = fileChooser.showOpenDialog(source.getScene().getWindow());

            if (file != null) {
                String filepath = file.getPath();
                fileTF.setText(filepath);
            }
        });
        Label titleLabel = new Label();
        titleLabel.setText("Enter song title:");
        Label artistLabel = new Label();
        artistLabel.setText("Enter artist:");
        Label genreLabel = new Label();
        genreLabel.setText("Enter genre:");
        Label timeLabel = new Label();
        timeLabel.setText("Enter time:");
        Label fileLabel = new Label();
        fileLabel.setText("Enter song file name:");

        VBox box = new VBox(titleLabel, titleTF, artistLabel, artistTF, genreLabel, genreTF, timeLabel, timeTF, fileLabel, fileTF, chooseFileButton);
        dialog.getDialogPane().setContent(box);

        Optional<ButtonType> ok = dialog.showAndWait();
        if (ok.get() == ButtonType.OK)
            System.out.println("Title = " + titleTF.getText() + " Artist = " + artistTF.getText() + " Genre = "
                    + genreTF.getText() + " Time = " + timeTF.getText() + " File = " + fileTF.getText());

        int time = Integer.parseInt(timeTF.getText());
        songDao.saveSong(titleTF.getText(), artistTF.getText(), genreTF.getText(), time, fileTF.getText());
        refreshSongLV();

        titleTF.clear();
        artistTF.clear();
        genreTF.clear();
        timeTF.clear();
        fileTF.clear();
    }
    // DELETES SONG FROM SONG DATABASE
    @FXML
    void deletSongLib(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Delete song");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        Label confirm = new Label("Are you sure you want to continue?");
        dialog.getDialogPane().setContent(confirm);
        Optional<ButtonType> button = dialog.showAndWait();

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

                        songDao.deleteSong(s);
                    }

            } catch (Exception e) {
                System.out.println("Something went wrong");
            }
    }
    // SETS UP EDIT SONG DIALOG BOX AND ENABLES EDITING OF SONGS
    @FXML
    void editSongLib(ActionEvent event) throws IOException {

        Dialog<ButtonType> dialog = new Dialog<>();

        dialog.setTitle("edit song dialog");
        dialog.setHeaderText("Edit Song");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        TextField titleTF = new TextField();
        TextField artistTF = new TextField();
        TextField genreTF = new TextField();
        TextField timeTF = new TextField();
        TextField fileTF = new TextField();

        Label titleLabel = new Label();
        titleLabel.setText("Edit song title:");
        Label artistLabel = new Label();
        artistLabel.setText("Edit artist:");
        Label genreLabel = new Label();
        genreLabel.setText("Edit genre:");
        Label timeLabel = new Label();
        timeLabel.setText("Edit time:");
        Label fileLabel = new Label();
        fileLabel.setText("Edit song file name:");

        VBox box = new VBox(titleLabel, titleTF, artistLabel, artistTF, genreLabel, genreTF, timeLabel, timeTF, fileLabel, fileTF);
        dialog.getDialogPane().setContent(box);

        Song selectedSong = songLV.getSelectionModel().getSelectedItem();

        int ID = selectedSong.getSongID();
        titleTF.setText(selectedSong.getSongTitle());
        artistTF.setText(selectedSong.getArtist());
        genreTF.setText(selectedSong.getGenre());
        timeTF.setText(selectedSong.getSongTime()+"");
        fileTF.setText(selectedSong.getSongFile());

        Optional<ButtonType> ok = dialog.showAndWait();
        if (ok.get() == ButtonType.OK)

            System.out.println("Title = " + titleTF.getText() + " Artist = " + artistTF.getText() + " Genre = "
                    + genreTF.getText() + " Time = " + timeTF.getText() + " File = " + fileTF.getText());

        int time = Integer.parseInt(timeTF.getText());
        songDao.deleteSong(selectedSong);
        songDao.saveSong(titleTF.getText(), artistTF.getText(), genreTF.getText(), time, fileTF.getText());
        refreshSongLV();

        titleTF.clear();
        artistTF.clear();
        genreTF.clear();
        timeTF.clear();
        fileTF.clear();
    }


    // ADDS A NEW PLAYLIST TO DATABASE
    @FXML
    void newPlayList(ActionEvent event) throws IOException{
        Dialog<ButtonType> dialog = new Dialog<>();

        dialog.setTitle("new playlist dialog");
        dialog.setHeaderText("New Playlist");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        TextField playlistTF = new TextField();
        Label nameLabel = new Label();
        nameLabel.setText("Enter playlist name:");
        VBox box = new VBox(nameLabel, playlistTF);
        dialog.getDialogPane().setContent(box);

        Optional<ButtonType> ok = dialog.showAndWait();
        if (ok.get() == ButtonType.OK)
            System.out.println("Playlist name = " + playlistTF.getText());

        Playlist playlist = new Playlist();
        playlistLV.getItems().add(playlist);

        playlistDao.savePlaylist(playlistTF.getText());
        refreshPlaylistLV();

        playlistTF.clear();
    }

 // DELETES SONG FROM DATABASE
    @FXML
    void deletePlayList(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("delete playlist");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        Label confirm = new Label("Deleting playlist will not delete any songs");
        dialog.getDialogPane().setContent(confirm);
        Optional<ButtonType> button = dialog.showAndWait();

        if (button.get() == ButtonType.OK)
            try {
                ObservableList<Integer> chosenIndex = playlistLV.getSelectionModel().getSelectedIndices();
                if (chosenIndex.size() == 0)
                    System.out.println("Choose a song");
                else
                    for (Object index : chosenIndex) {
                        System.out.println("You chose " + playlistLV.getSelectionModel().getSelectedItem());
                        Playlist p = (Playlist) playlistLV.getItems().get((int) index);
                        playlistLV.getItems().remove(playlistLV.getSelectionModel().getSelectedItem());

                        playlistDao.deletePlaylist(p);
                    }

            } catch (Exception e) {
                System.out.println("Something went wrong");
            }
    }
    //SETS UP DIALOG AND ENABLES EDITING OF PLAYLISTS
    @FXML
    void editPlayList(ActionEvent event) throws IOException {
        Dialog<ButtonType> dialog = new Dialog<>();

        dialog.setTitle("edit playlist dialog");
        dialog.setHeaderText("Edit Playlist");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        TextField playlistTF = new TextField();
        Label nameLabel = new Label();
        nameLabel.setText("Enter playlist name:");
        VBox box = new VBox(nameLabel,playlistTF);
        dialog.getDialogPane().setContent(box);

        Playlist selectedPlaylist = playlistLV.getSelectionModel().getSelectedItem();
        playlistTF.setText(selectedPlaylist.getPlaylistName());

        Optional<ButtonType> ok = dialog.showAndWait();
        // Derefter kan vi henter felternes indhold ud og gøre hvad der skal gøres...
        if (ok.get() == ButtonType.OK)
            System.out.println("Playlist name = " + playlistTF.getText());

        playlistDao.deletePlaylist(selectedPlaylist);
        playlistDao.savePlaylist(playlistTF.getText());

        refreshPlaylistLV();

        playlistTF.clear();
    }

 // ADDS SONG TO PLAYLIST BY CONNECTING A SELECTED SONG WITH A SELECTED PLAYLIST
    @FXML
    void addSongPlaylist(ActionEvent event) {
                ObservableList<Integer> chosenIndex = songLV.getSelectionModel().getSelectedIndices();
                if (chosenIndex.size() != 0) {
                    ObservableList<Integer> chosenIndex1 = playlistLV.getSelectionModel().getSelectedIndices();
                    if (chosenIndex1.size() == 0)
                        System.out.println("Choose a playlist");
                    else
                        for (Object index : chosenIndex) {
                            System.out.println("You chose " + songLV.getSelectionModel().getSelectedItem());
                            Song s = (Song) songLV.getItems().get((int) index);
                            Playlist playlist = (Playlist) playlistLV.getSelectionModel().getSelectedItem();
                            songsOnPlaylistDao.addSongPL(s.getSongID(), playlist.getPlaylistID());
                            List<Song> songs = songsOnPlaylistDao.getAllSongsOnPlaylist(playlist);
                            soP.getItems().clear();
                            for (Song song : songs){
                                soP.getItems().add(song);
                            }
                        }
                }
                else  System.out.println("Choose a song");
       }
    // DELETES SONG FROM PLAYLIST
    @FXML
    void deleteSongfromPlayList(ActionEvent event) {
        ObservableList<Integer> chosenIndex = soP.getSelectionModel().getSelectedIndices();
        if (chosenIndex.size() != 0) {
            for (Object index : chosenIndex) {
                Song s = (Song) soP.getItems().get((int) index);
                Playlist playlist = (Playlist) playlistLV.getSelectionModel().getSelectedItem();
                songsOnPlaylistDao.deleteSongPL(s);
                List<Song> songs = songsOnPlaylistDao.getAllSongsOnPlaylist(playlist);
                soP.getItems().remove(s);
            }
        }
    }

    // SHOWS ALL SONGS ON A SELECTED PLAYLIST
    @FXML
    void showSoP(MouseEvent event) {
        System.out.println("showSoP mouse event works");
         soP.getItems().clear();
                Playlist playlist = (Playlist) playlistLV.getSelectionModel().getSelectedItem();
                List<Song> songs = songsOnPlaylistDao.getAllSongsOnPlaylist(playlist);
                for (Song song : songs) {
                    soP.getItems().add(song);
                }
        }

// DID NOT MANAGE TO IMPLEMENT
    @FXML
    void forward(ActionEvent event) {

    }

// DID NOT MANAGE TO IMPLEMENT
    @FXML
    void moveDown(ActionEvent event) {

    }

    // DID NOT MANAGE TO IMPLEMENT
    @FXML
    void moveUp(ActionEvent event) {

    }

    // CHOSES A FILE PATH IN ORDER TO PLAY A SONG FROM EITHER SONG LISTVIEW OR SONGS ON PLAYLIST LISTVIEW
   private String getFileFromSelected() {
       ObservableList<Integer> chosenIndex1 = songLV.getSelectionModel().getSelectedIndices();
       if (chosenIndex1.size() != 0) {
           for (Object index : chosenIndex1) {
               Song s = (Song) songLV.getItems().get((int) index);
               return s.getSongFile();
           }
       }
           ObservableList<Integer> chosenIndex2 = soP.getSelectionModel().getSelectedIndices();
           if (chosenIndex2.size() != 0) {
               for (Object index : chosenIndex2) {
                   Song s = (Song) soP.getItems().get((int) index);
                   return s.getSongFile();
               }
           }
           return null;
   }

   // METHOD FOR PLAYING A SONG
    Media lyd;
    MediaPlayer mediaPlayer;
    @FXML
    void play(ActionEvent event) {
            if (afspiller) {
            mediaPlayer.stop();
            afspiller = false;
        } else {
            lyd = new Media(String.valueOf(getClass().getResource(getFileFromSelected())));
            mediaPlayer = new MediaPlayer(lyd);
            mediaPlayer.seek(mediaPlayer.getStartTime());
            songIsPlaying.setText(mediaPlayer.getMedia().getSource() + "...is playing");
            afspiller = true;
            mediaPlayer.play();

        }
    }

     // DID NOT MANAGE TO IMPLEMENT
    @FXML
    void previous(ActionEvent event) {

    }

    // DID NOT MANAGE TO IMPLEMENT
    @FXML
    void search(ActionEvent event)  {

    }


    @FXML
    void closeProgram(ActionEvent event) {
        stage = (Stage) programPane.getScene().getWindow();
        stage.close();
    }
}
