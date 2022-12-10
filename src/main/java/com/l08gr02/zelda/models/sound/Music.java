package com.l08gr02.zelda.models.sound;

import javax.sound.sampled.*;
import java.io.IOException;

public class Music extends Sound {
    // constructor
    public Music(String file) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        super("music", file);
    }

    // method
    @Override
    public void play() {
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
