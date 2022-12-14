package com.l08gr02.zelda.presenters.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.elements.moving.Fighter;
import com.l08gr02.zelda.models.sound.SoundEffect;
import com.l08gr02.zelda.presenters.GameplayPresenter;
import com.l08gr02.zelda.viewers.Viewer;

import java.util.List;

public abstract class FighterPresenter<T extends Fighter> extends MoverPresenter<T> {
    protected SoundEffect healingSFX, damagedSFX;

    // construtor
    public FighterPresenter(T model, Viewer<T> viewer){
        super(model, viewer);
    }

    // métodos
    public void heal(float heartsGained){
        model.heal(heartsGained);
        healingSFX.play();
    }

    public void takeDamage(float heartsLost){
        model.takeDamage(heartsLost);
        damagedSFX.play();
    }

    public void attack(){
        model.attack();
    }

    public abstract void update(TextGraphics graphics, List<GameplayPresenter.ACTION> actions);
}
