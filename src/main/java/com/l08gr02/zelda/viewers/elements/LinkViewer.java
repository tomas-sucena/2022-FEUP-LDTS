package com.l08gr02.zelda.viewers.elements;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.Link;
import com.l08gr02.zelda.viewers.Viewer;

import java.awt.*;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public class LinkViewer implements Viewer<Link> {
    private Sprite sprite;
    private int xGrid = 0, yGrid = 0;

    // constructor
    public LinkViewer(){
        sprite = new Sprite(24, "Link", "retro");
        sprite.setPixels(xGrid, yGrid);
    }

    // method
    @Override
    public void draw(TextGraphics graphics, Link link) {
        int x = link.getPosition().getX();
        int y = link.getPosition().getY();

        Color pixels[][] = sprite.getPixels();

        for(int i = 0; i < sprite.getHeight(); i++){
            for(int j = 0; j < sprite.getWidth(); j++){
                graphics.setBackgroundColor(new TextColor.RGB(pixels[i][j].getRed(), pixels[i][j].getGreen(),pixels[i][j].getBlue()));
                graphics.setCharacter(x + i, y + j, ' ');
            }
        }
    }

    public void setSprite(ACTION action){
        switch (action) {
            case UP -> {yGrid = 4;}

            case DOWN -> {yGrid = 1;}
        }

        if (xGrid == 8){
            xGrid = 0;
        }
        else if (action != ACTION.NOTHING){
            xGrid++;
        }

        sprite.setPixels(xGrid, yGrid);
    }

}
