package com.l08gr02.zelda.viewers.elements;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.Link;
import com.l08gr02.zelda.models.elements.Monster;
import com.l08gr02.zelda.viewers.SpriteViewer;
import com.l08gr02.zelda.viewers.Viewer;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public class MonsterViewer extends SpriteViewer<Monster> {

    public MonsterViewer(){
        super(new Sprite(44,44,"gfx","log"));
    }

    // method
    /*
    public void draw(TextGraphics graphics, Monster monster) {
        int x = monster.getPosition().getX();
        int y =  monster.getPosition().getY();

        graphics.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);

        graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(x, y), "T");
    }*/
    public void draw(TextGraphics graphics, Monster monster){
        super.draw(graphics,monster);
    }

    public void setSprite(ACTION action) {
        switch (action) {
            case UP -> {yGrid = 1;}

            case DOWN -> {yGrid = 0;}

            case LEFT -> {yGrid = 2;}

            case RIGHT -> {yGrid = 3;}

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
