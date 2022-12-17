package com.l08gr02.zelda.presenters;

import com.googlecode.lanterna.screen.Screen;
import com.l08gr02.zelda.gui.Camera;
import com.l08gr02.zelda.models.Gameplay;
import com.l08gr02.zelda.models.sound.Music;
import com.l08gr02.zelda.presenters.dungeon.DungeonPresenter;
import com.l08gr02.zelda.viewers.GameplayViewer;
import com.l08gr02.zelda.viewers.dungeon.DungeonViewer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

public class GameplayPresenter {
    private GameplayViewer viewer;
    private DungeonPresenter dungeonPresenter;
    private Music music;
    public enum ACTION {UP, DOWN, LEFT, RIGHT, SPRINT, ATTACK, QUIT, NOTHING};

    // constructor
    public GameplayPresenter(Gameplay model, GameplayViewer viewer) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.viewer = viewer;

        // definir o Link como o ator que a câmara vai filmar
        Camera camera = viewer.getGUI().getCamera();
        camera.setActor(model.getDungeon().getLink());

        // criar o presenter
        camera.setLimits(model.getDungeon().getMap());
        dungeonPresenter = new DungeonPresenter(model.getDungeon(), new DungeonViewer());

        music = new Music("overworld");
    }

    // methods
    public void update() throws IOException, InterruptedException {
        music.play();

        int FPS = 60;
        int frameTime = 1000 / FPS;

        Screen screen = viewer.getGUI().getScreen();

        while (true){
            long startTime = System.currentTimeMillis();

            List<ACTION> actions = viewer.getActions();

            if (actions.contains(ACTION.QUIT)){
                screen.close();
                break;
            }

            screen.clear();
            dungeonPresenter.setLinkActions(actions);
            dungeonPresenter.update(viewer.getGUI());
            screen.refresh();

            // mover a câmara
            viewer.getGUI().getCamera().film();

            sleep(frameTime - startTime);
        }

        music.stop();
    }

    public void sleep(long sleepTime) throws InterruptedException {
        if (sleepTime > 0)
            Thread.sleep(sleepTime);
    }

}
