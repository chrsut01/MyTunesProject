package com.example.mytunesproject;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MediaP {

    private static MediaPlayer mediaPlayer;

        @FXML
        protected void play(ActionEvent actionEvent) {
            try {
                Media lyd = new Media(String.valueOf(getClass().getResource("Right-now.mp3")));
                mediaPlayer = new MediaPlayer(lyd);
                mediaPlayer.seek(mediaPlayer.getStartTime());
                mediaPlayer.play();

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }



    }


}
