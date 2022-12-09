package com.l08gr02.zelda.models;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {
    private Clip clip;
    private AudioInputStream song;

    // constructor
    public Music(String file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        song = loadSong(file);

        clip = AudioSystem.getClip();
        clip.open(song);
    }

    // methods
    public AudioInputStream loadSong(String file) throws UnsupportedAudioFileException, IOException {
        return AudioSystem.getAudioInputStream(new File("src/main/resources/sound/music/" + file + ".wav"));
    }

    public void play(){
        clip.start();
    }

    public void stop(){
        clip.stop();
        clip.close();
    }
}
