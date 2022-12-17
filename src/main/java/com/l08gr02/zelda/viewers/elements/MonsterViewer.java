package com.l08gr02.zelda.viewers.elements;

import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.moving.monsters.Monster;
import com.l08gr02.zelda.viewers.SpriteViewer;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public class MonsterViewer extends SpriteViewer<Monster> {
    // construtor
    public MonsterViewer(){
        super(new Sprite(32,32,"monsters","log"));
    }

    // métodos
    @Override
    public void draw(GUI gui, Monster monster){
        super.draw(gui, monster);
    }

    @Override
    public void setSprite(ACTION action) {
        switch (action) {
            case UP -> {yGrid = 1;}

            case DOWN -> {yGrid = 0;}

            case LEFT -> {yGrid = 3;}

            case RIGHT -> {yGrid = 2;}
        }

        xGrid = (xGrid >= 3) ? 0 : xGrid + 1;

        sprite.setPixels(xGrid, yGrid);
    }

}
