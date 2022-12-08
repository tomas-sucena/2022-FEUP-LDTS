package com.l08gr02.zelda.presenters;

import com.l08gr02.zelda.models.Gameplay;
import com.l08gr02.zelda.presenters.dungeon.DungeonPresenter;
import com.l08gr02.zelda.viewers.GameplayViewer;

import java.io.IOException;
import java.util.List;

import static java.lang.Thread.sleep;

public class GameplayPresenter {
    private final Gameplay model;
    private GameplayViewer viewer;
    private DungeonPresenter dungeonPresenter;
    public enum ACTION {UP, DOWN, LEFT, RIGHT, SPRINT, ATTACK, QUIT, NOTHING};

    // constructor
    public GameplayPresenter(Gameplay model, GameplayViewer viewer) {
        this.model = model;
        this.viewer = viewer;

        dungeonPresenter = new DungeonPresenter(model.getDungeon(), viewer.getDungeonViewer());
    }

    // methods
    public void update() throws IOException, InterruptedException {
        while (true){
            List<ACTION> actions = viewer.getActions();

            if (actions.contains(ACTION.QUIT)){
                viewer.getScreen().close();
                break;
            }

            viewer.getScreen().clear();
            dungeonPresenter.update(viewer.getGraphics(), actions);
            viewer.getScreen().refresh();

            sleep(50);
        }
    }

}
