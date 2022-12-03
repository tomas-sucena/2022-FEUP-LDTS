package com.l08gr02.zelda;

import com.l08gr02.zelda.models.Gameplay;
import com.l08gr02.zelda.presenters.GameplayPresenter;
import com.l08gr02.zelda.viewers.GameplayViewer;

import java.io.IOException;

public class Game {
    public static void main(String[] args) {
        try {
            Gameplay gameplay = new Gameplay();
            GameplayViewer gameplayViewer = new GameplayViewer(400, 160);

            GameplayPresenter gameplayPresenter = new GameplayPresenter(gameplay, gameplayViewer);
            gameplayPresenter.update();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
