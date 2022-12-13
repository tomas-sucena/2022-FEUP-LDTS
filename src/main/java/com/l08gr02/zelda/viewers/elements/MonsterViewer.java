package com.l08gr02.zelda.viewers.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.gui.Camera;
import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.moving.Monster;
import com.l08gr02.zelda.viewers.SpriteViewer;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public class MonsterViewer extends SpriteViewer<Monster> {
    // construtor
    public MonsterViewer(Camera camera){
        super(new Sprite(30,30,"gfx","log"), camera);
    }

    // métodos
    @Override
    public void draw(TextGraphics graphics, Monster monster){
        super.draw(graphics,monster);
    }

    @Override
    public void setSprite(ACTION action) {
        switch (action) {
            case UP -> {yGrid = 1;}

            case DOWN -> {yGrid = 0;}

            case LEFT -> {yGrid = 3;}

            case RIGHT -> {yGrid = 2;}

        }

        if (xGrid == 4){
            xGrid = 0;
        }
        else if (action != ACTION.NOTHING){
            xGrid++;
        }

        sprite.setPixels(xGrid, yGrid);
    }

}
