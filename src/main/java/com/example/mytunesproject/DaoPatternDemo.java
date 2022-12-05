package com.example.mytunesproject;


public class DaoPatternDemo {
    public static void main(String[] args) {
        SongDao songDao = new SongDaoImpl();

        /*
        //print all students
        for (Song song : SongDao.getAllSongs()) {
            System.out.println("Song: [songID : " + song.getSongID() + ", Title : " + song.getSongTitle() + " ]");
        }*/
    }

/*
    //update student
    Song song = SongDao.getAllSongs().get(0);
    song.setSongTitle("Michael");
    songDao.updateSong(song);

    //get the student
        songDao.getSong(0);
        System.out.println("Student: [RollNo : "+student.getRollNo()+", Name : "+student.getName()+" ]");
*/
}