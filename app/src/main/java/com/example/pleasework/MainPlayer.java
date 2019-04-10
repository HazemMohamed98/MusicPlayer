package com.example.pleasework;

import android.media.MediaPlayer;
import android.widget.SeekBar;
import java.io.IOException;
import java.util.List;


/*
KNOWN BUGS

law 3amel pause w dost 3l recycler same song should restart song
 */

public class MainPlayer {
    MediaPlayer Player;

    List<Song> songList; //Library
    int currentIndex;

    SeekBar seekBar;

    public MainPlayer(List<Song> songList , SeekBar seekBar){
        //gets refrence to time and has thread in it
        //the thread thingi

        Player = new MediaPlayer();
        this.songList = songList;
        this.seekBar = seekBar;
        currentIndex = 0;//should get index of last time app was used
    }

    /*
    Thread thread = new Thread() {

        @Override
        public void run() {
            try {
                while (!thread.isInterrupted()) {
                    Thread.sleep(10);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(player.getCurrentPosition());
                            long mins = TimeUnit.MILLISECONDS.toMinutes(player.getCurrentPosition());
                            for (int i = 0; i < mins; i++)
                                seconds -= 60;

                            startTime.setText(mins + ":" + seconds);
                        }
                    });
                }
            } catch (InterruptedException e) {
            }
        }
    };
*/

    public void pauseSong(){
        if(Player.isPlaying()) {
            Player.pause();
        }
    }

    public void playResumeSong(int _index) {
        if (Player.isPlaying() == true)//Already Playing a Song
        {
            play(_index);

//            seekBar.setProgress(0);
//            seekBar.setMax((int)song.getDuration());

        } else {//not playing a song
            if (currentIndex != _index) {//Playing a new song
                currentIndex = _index;
                play(_index);
            } else
                Player.start();
        }
    }

    public void playNextSong() {
        if ((currentIndex + 1) == songList.size())
            currentIndex = 0;
        playResumeSong(currentIndex + 1);
    }

    public void playPrevSong() {
        if ((currentIndex - 1) == -1)
            currentIndex = songList.size() - 1;
        playResumeSong(currentIndex - 1);
    }

    private void play(int _index){

        Player.stop();
        Player = new MediaPlayer();
        Song song = songList.get(_index);
        try {
            Player.setDataSource(song.getLocation());
            Player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Player.start();
        currentIndex = _index;
    }

}