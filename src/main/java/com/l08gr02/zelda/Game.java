package com.l08gr02.zelda;

import com.l08gr02.zelda.models.Gameplay;
import com.l08gr02.zelda.presenters.GameplayPresenter;
import com.l08gr02.zelda.viewers.GameplayViewer;

public class Game {
    public static void main(String[] args) {
        int TILE_SIZE = 16;

        try {
            Gameplay gameplay = new Gameplay();
            GameplayViewer gameplayViewer = new GameplayViewer(20 * TILE_SIZE, 10 * TILE_SIZE);

            GameplayPresenter gameplayPresenter = new GameplayPresenter(gameplay, gameplayViewer);
            gameplayPresenter.update();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
