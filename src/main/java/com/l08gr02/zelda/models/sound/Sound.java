package com.l08gr02.zelda.models.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public abstract class Sound {
    protected Clip clip;
    private AudioInputStream song;

    // constructor
    public Sound(String type, String file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        song = loadSong(type, file);

        clip = AudioSystem.getClip();
        clip.open(song);
    }

    // methods
    public AudioInputStream loadSong(String type, String file) throws UnsupportedAudioFileException, IOException {
        return AudioSystem.getAudioInputStream(new File("src/main/resources/sound/" + type + "/" + file + ".wav"));
    }

    public void stop(){
        clip.stop();
        clip.close();
    }

    public abstract void play();
}
