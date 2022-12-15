package com.l08gr02.zelda.presenters.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.elements.moving.Fighter;
import com.l08gr02.zelda.models.sound.SoundEffect;
import com.l08gr02.zelda.viewers.Viewer;

import java.util.List;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public abstract class FighterPresenter<T extends Fighter> extends MoverPresenter<T> {
    private int immunityFrames;
    protected SoundEffect healingSFX, damagedSFX;

    // construtor
    public FighterPresenter(T model, Viewer<T> viewer){
        super(model, viewer);

        immunityFrames = 0;
    }

    // métodos
    public void heal(float heartsGained){
        model.heal(heartsGained);
        healingSFX.play();
    }

    public void takeDamage(float heartsLost, ACTION attackDirection){
        if (immunityFrames > 0){
            return;
        }

        immunityFrames = 8;

        model.takeDamage(heartsLost);
        try {
            damagedSFX.play();
        }
        catch (Exception e){}

        switch (attackDirection){
            case UP -> moveUp(16);

            case DOWN -> moveDown(16);

            case LEFT -> moveLeft(16);

            case RIGHT -> moveRight(16);
        }
    }

    public void attack(){
        model.attack();
    }

    public void decreaseImmunity(){
        immunityFrames -= (immunityFrames > 0) ? 1 : 0;
    }

    public abstract void update(TextGraphics graphics, List<ACTION> actions);
}