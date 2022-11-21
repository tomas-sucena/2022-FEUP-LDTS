package com.l08gr02.zelda.viewers.elements;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.Link;
import com.l08gr02.zelda.viewers.Viewer;

import java.awt.*;

public class LinkViewer implements Viewer<Link> {

    private Sprite sprite;

    public LinkViewer(){
        sprite = new Sprite();
        sprite.setPixels(0,0,"Link","knight");
    }

    @Override
    public void draw(Screen screen, Link link){
        int x;
        int y = link.getPosition().getY() - 32;
        Color pixels[][] = sprite.getPixels();
        for(int i = 0; i < sprite.getHeight(); i++){
            x = link.getPosition().getX();
            for(int j = 0; j < sprite.getWidth(); j++){
                screen.setCharacter(y, x, new TextCharacter(' ').withBackgroundColor(new TextColor.RGB(pixels[i][j].getRed(), pixels[i][j].getBlue(), pixels[i][j].getGreen())));
                x++;
            }
            y++;
        }
    }
}
