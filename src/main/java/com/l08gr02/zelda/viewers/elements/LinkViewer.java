package com.l08gr02.zelda.viewers.elements;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.Link;
import com.l08gr02.zelda.viewers.Viewer;

import java.awt.*;

public class LinkViewer implements Viewer<Link> {
    private Sprite sprite;

    // constructor
    public LinkViewer(){
        sprite = new Sprite();
        sprite.setPixels(0,0,"Link","retro");
    }

    // method
    @Override
    public void draw(TextGraphics graphics, Link link){
        int x = link.getPosition().getX();
        int y = link.getPosition().getY();

        Color pixels[][] = sprite.getPixels();

        for(int i = 0; i < sprite.getHeight(); i++){
            for(int j = 0; j < sprite.getWidth(); j++){
                graphics.setBackgroundColor(new TextColor.RGB(pixels[i][j].getRed(), pixels[i][j].getBlue(), pixels[i][j].getGreen()));
                graphics.setCharacter(x + i, y + j, ' ');
            }
        }
    }

}
