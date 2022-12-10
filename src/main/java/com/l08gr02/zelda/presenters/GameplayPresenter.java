package com.l08gr02.zelda.presenters;

import com.l08gr02.zelda.models.Gameplay;
import com.l08gr02.zelda.models.sound.Music;
import com.l08gr02.zelda.presenters.dungeon.DungeonPresenter;
import com.l08gr02.zelda.viewers.GameplayViewer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

public class GameplayPresenter {
    private final Gameplay model;
    private GameplayViewer viewer;
    private DungeonPresenter dungeonPresenter;
    private Music music;
    public enum ACTION {UP, DOWN, LEFT, RIGHT, SPRINT, ATTACK, QUIT, NOTHING};

    // constructor
    public GameplayPresenter(Gameplay model, GameplayViewer viewer) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.model = model;
        this.viewer = viewer;

        dungeonPresenter = new DungeonPresenter(model.getDungeon(), viewer.getDungeonViewer());

        music = new Music("overworld");
    }

    // methods
    public void update() throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException {
        //music.play();

        int FPS = 60;
        int frameTime = 1000 / FPS;

        while (true){
            long startTime = System.currentTimeMillis();

            List<ACTION> actions = viewer.getActions();

            if (actions.contains(ACTION.QUIT)){
                viewer.getScreen().close();
                break;
            }

            viewer.getScreen().clear();
            dungeonPresenter.update(viewer.getGraphics(), actions);
            viewer.getScreen().refresh();

            sleep(frameTime - startTime);
        }

        //music.stop();
    }

    public void sleep(long sleepTime) throws InterruptedException {
        if (sleepTime > 0)
            Thread.sleep(sleepTime);
    }

}
