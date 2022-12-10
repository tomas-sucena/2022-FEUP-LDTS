package com.l08gr02.zelda.models.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public abstract class Sound {
    protected Clip clip;
    private AudioInputStream song;
    private String songPath;

    // constructor
    public Sound(String type, String file) {
        songPath = "src/main/resources/sound/" + type + "/" + file + ".wav";
    }

    // methods
    public AudioInputStream loadSong() throws UnsupportedAudioFileException, IOException {
        return AudioSystem.getAudioInputStream(new File(songPath));
    }

    public void play() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        song = loadSong();

        clip.open(song);
        clip.start();
    }

    public void stop() throws IOException {
        clip.stop();
        clip.close();

        song.close();
    }

}
