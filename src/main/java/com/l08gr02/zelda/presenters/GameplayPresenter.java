package com.l08gr02.zelda.presenters;

import com.l08gr02.zelda.models.Gameplay;
import com.l08gr02.zelda.presenters.dungeon.DungeonPresenter;
import com.l08gr02.zelda.viewers.GameplayViewer;

import java.io.IOException;

public class GameplayPresenter {
    private Gameplay model;
    private GameplayViewer viewer;
    private DungeonPresenter dungeonPresenter;
    public enum ACTION {UP, DOWN, LEFT, RIGHT, QUIT, NOTHING};

    // constructor
    public GameplayPresenter(Gameplay model, GameplayViewer viewer) {
        this.model = model;
        this.viewer = viewer;

        dungeonPresenter = new DungeonPresenter(model.getDungeon(), viewer.getDungeonViewer());
    }

    // methods
    public void update() throws IOException {
        while (viewer.getAction() != ACTION.QUIT){
            dungeonPresenter.update(viewer.getAction());
        }
    }

}
