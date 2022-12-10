package com.l08gr02.zelda.models.sound;

import javax.sound.sampled.*;

public class Music extends Sound {
    // constructor
    public Music(String file) {
        super("music", file);
    }

    // method
    @Override
    public void play() {
        super.play();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
