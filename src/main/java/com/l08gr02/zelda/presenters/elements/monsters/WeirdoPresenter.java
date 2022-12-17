package com.l08gr02.zelda.presenters.elements.monsters;

import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.elements.moving.monsters.Weirdo;
import com.l08gr02.zelda.presenters.GameplayPresenter;
import com.l08gr02.zelda.viewers.elements.monsters.WeirdoViewer;

import java.util.Random;

public class WeirdoPresenter extends MonsterPresenter<Weirdo> {
    private int actionLockCounter = 0;
    private int genMove = 2;
    private GameplayPresenter.ACTION action = GameplayPresenter.ACTION.LEFT;

    // constructor
    public WeirdoPresenter(Weirdo model, WeirdoViewer viewer){
        super(model, viewer);
    }

    // methods
    @Override
    public void update(GUI gui) {
        super.decreaseImmunity();

        if (!model.collidesWith(gui.getCamera())){
            return;
        }

        actionLockCounter++;

        if (actionLockCounter > 60) {
            Random rng = new Random();
            genMove = rng.nextInt(4);
            actionLockCounter = 0;
        }

        switch (genMove){
            case 0 -> {moveUp(model.getSpeed()); action= GameplayPresenter.ACTION.UP;}
            case 1 -> {moveDown(model.getSpeed()); action= GameplayPresenter.ACTION.DOWN;}
            case 2 -> {moveLeft(model.getSpeed()); action= GameplayPresenter.ACTION.LEFT;}
            case 3 -> {moveRight(model.getSpeed()); action= GameplayPresenter.ACTION.RIGHT;}
        }

        ((WeirdoViewer) viewer).setSprite(action);
        viewer.draw(gui, model);
    }
}
