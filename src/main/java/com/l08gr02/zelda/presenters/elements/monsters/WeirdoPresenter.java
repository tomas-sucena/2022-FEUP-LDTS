package com.l08gr02.zelda.presenters.elements.monsters;

import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.elements.moving.monsters.Weirdo;
import com.l08gr02.zelda.viewers.elements.moving.monsters.WeirdoViewer;

import java.util.Random;

public class WeirdoPresenter extends MonsterPresenter<Weirdo> {
    private int actionLockCounter = 0;
    private int genMove = 2;

    // constructor
    public WeirdoPresenter(Weirdo model, WeirdoViewer viewer){
        super(model, viewer);
    }

    // methods
    @Override
    public void update(GUI gui) {
        if (!mustUpdate(gui)){
            return;
        }

        actionLockCounter++;

        if (actionLockCounter > 60) {
            Random rng = new Random();
            genMove = rng.nextInt(4);
            actionLockCounter = 0;
        }

        switch (genMove){
            case 0 -> moveUp(model.getSpeed());
            case 1 -> moveDown(model.getSpeed());
            case 2 -> moveLeft(model.getSpeed());
            case 3 -> moveRight(model.getSpeed());
        }

        ((WeirdoViewer) viewer).setSprite(model.getDirection());
        viewer.draw(gui, model);
    }
}
