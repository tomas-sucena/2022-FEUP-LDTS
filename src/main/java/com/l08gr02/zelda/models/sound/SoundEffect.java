package com.l08gr02.zelda.models.sound;

import javax.sound.sampled.*;
import java.io.IOException;

public class SoundEffect extends Sound {
    // constructor
    public SoundEffect(String file) {
        super("sfx", file);
    }

    // method
    @Override
    public void play() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        super.play();
        super.stop();
    }
}
