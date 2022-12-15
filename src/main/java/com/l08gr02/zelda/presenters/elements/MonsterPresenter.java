package com.l08gr02.zelda.presenters.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.elements.moving.monsters.Monster;
import com.l08gr02.zelda.viewers.elements.MonsterViewer;

import java.util.List;
import java.util.Random;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public class MonsterPresenter extends FighterPresenter<Monster> {
    private int actionLockCounter = 0;
    private int genMove = 2;
    private ACTION action = ACTION.LEFT;

    // construtor
    public MonsterPresenter(Monster model, MonsterViewer viewer) {
        super(model, viewer);
    }

    // métodos
    @Override
    public void update(TextGraphics graphics, List<ACTION> actions) {
        super.decreaseImmunity();

        actionLockCounter++;

        if (actionLockCounter > 60) {
            Random rnd = new Random();
            genMove = rnd.nextInt(4);
            actionLockCounter=0;
        }

        switch (genMove){
            case 0 -> {moveUp(model.getSpeed()); action=ACTION.UP;}
            case 1 -> {moveDown(model.getSpeed()); action=ACTION.DOWN;}
            case 2 -> {moveLeft(model.getSpeed()); action=ACTION.LEFT;}
            case 3 -> {moveRight(model.getSpeed()); action=ACTION.RIGHT;}
        }

        ((MonsterViewer) viewer).setSprite(action);
        viewer.draw(graphics, model);
    }

}
