package com.l08gr02.zelda;

import com.l08gr02.zelda.viewers.GameViewer;

import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException {
        GameViewer gui = new GameViewer(400, 160);
    }
}