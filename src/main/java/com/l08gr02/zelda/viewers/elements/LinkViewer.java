package com.l08gr02.zelda.viewers.elements;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.Link;
import com.l08gr02.zelda.viewers.SpriteViewer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public class LinkViewer implements SpriteViewer<Link> {
    private Sprite sprite;
    private Sprite hearts ;
    private int xGrid = 0, yGrid = 0;

    // constructor
    public LinkViewer(){
        hearts = new Sprite(16,"gfx","objects");
        sprite = new Sprite(16, "Link", "character");
        sprite.setPixels(xGrid, yGrid);
    }

    // method
    @Override
    public void draw(TextGraphics graphics, Link link) {
        int x = link.getPosition().getX();
        int y = link.getPosition().getY();
        drawLife(graphics, link);

        Color pixels[][] = sprite.getPixels();

        for(int i = 0; i < sprite.getHeight(); i++){
            for(int j = 0; j < sprite.getWidth(); j++){
                graphics.setBackgroundColor(new TextColor.RGB(pixels[i][j].getRed(), pixels[i][j].getGreen(),pixels[i][j].getBlue()));
                graphics.setCharacter(x + i, y + j, ' ');
            }
        }
    }

    public void drawLife(TextGraphics graphics, Link link){
        float life = link.getHearts();
        int hearty = (int) life;
        hearts.setPixels(4,0);
        Color pixels[][] = hearts.getPixels();
        for(int i = 0; i<hearty;i++){
            for(int j = 0; j < sprite.getHeight(); j++){
                for(int k = 0; k < sprite.getWidth(); k++){
                    graphics.setBackgroundColor(new TextColor.RGB(pixels[j][k].getRed(), pixels[j][k].getGreen(),pixels[j][k].getBlue()));
                    graphics.setCharacter(i*16+j,k, ' ');
                }
            }
        }
        if(life%1 != 0){
            hearts.setPixels(8 - (int)(life%1 *4),0);
            pixels = hearts.getPixels();
            for(int j = 0; j < sprite.getHeight(); j++){
                for(int k = 0; k < sprite.getWidth(); k++){
                    graphics.setBackgroundColor(new TextColor.RGB(pixels[j][k].getRed(), pixels[j][k].getGreen(),pixels[j][k].getBlue()));
                    graphics.setCharacter(hearty*16+j,k, ' ');
                }
            }
        }
    }

    @Override
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
