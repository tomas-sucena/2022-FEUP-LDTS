package com.l08gr02.zelda.viewers.elements;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.Link;
import com.l08gr02.zelda.models.elements.Tile;
import com.l08gr02.zelda.viewers.Viewer;

import java.awt.*;

public class TileViewer implements Viewer<Tile> {
    private Sprite sprite;

    // constructor
    public TileViewer(){
        sprite = new Sprite(16, "Dungeon", "Overworld");
        sprite.setPixels(0,0);
    }

    // method
    @Override
    public void draw(TextGraphics graphics, Tile tile){
        int x = tile.getPosition().getX();
        int y = tile.getPosition().getY();

        Color pixels[][] = sprite.getPixels();

        for(int i = 0; i < sprite.getHeight(); i++){
            for(int j = 0; j < sprite.getWidth(); j++){
                graphics.setBackgroundColor(new TextColor.RGB(pixels[i][j].getRed(), pixels[i][j].getGreen(),pixels[i][j].getBlue()));
                graphics.setCharacter(x + i, y + j, ' ');
            }
        }
    }

}
