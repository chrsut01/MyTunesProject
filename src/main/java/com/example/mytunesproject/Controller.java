package com.example.mytunesproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

    public class Controller {

        @FXML
        private TextField filterField;

        @FXML
        private TextField songIsPlaying;

        @FXML
        private Slider volumeConttol;

        @FXML
        void closeProgram(ActionEvent event) {

        }

        @FXML
        void deletSongLib(ActionEvent event) {

        }

        @FXML
        void deletePlayList(ActionEvent event) {

        }

        @FXML
        void deleteSongfromPlayList(ActionEvent event) {

        }

        @FXML
        void editPlayList(ActionEvent event) {

        }

        @FXML
        void editSongLib(ActionEvent event) {

        }

        @FXML
        void forword(ActionEvent event) {

        }

        @FXML
        void moveDown(ActionEvent event) {

        }

        @FXML
        void moveUp(ActionEvent event) {

        }

        @FXML
        void newPlayList(ActionEvent event) {

        }

        @FXML
        void newSonglib(ActionEvent event) {

        }

        @FXML
        void play(ActionEvent event) {

        }

        @FXML
        void reverse(ActionEvent event) {

        }

        @FXML
        void search(ActionEvent event) {

        }

            @FXML
            private TextField insertArtist;

            @FXML
            private TextField insertTime;

            @FXML
            void cancelSongInfo(ActionEvent event) {

            }

            @FXML
            void chooseFile(ActionEvent event) {

            }

            @FXML
            void insertTitle(ActionEvent event) {

            }

            @FXML
            void moreGenre(ActionEvent event) {

            }

            @FXML
            void saveSongInfo(ActionEvent event) {

            }

        @FXML
        private TextField playlistName;

        @FXML
        void cancelEdit(ActionEvent event) {

        }

        @FXML
        void saveEdit(ActionEvent event) {

        }

        public static void main(String[] args) {
            System.out.println("Hello there, world!");
        }

}