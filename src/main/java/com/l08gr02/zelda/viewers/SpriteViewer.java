package com.l08gr02.zelda.viewers;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.Element;

import java.awt.*;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public abstract class SpriteViewer<T extends Element> implements Viewer<T> {
    protected Sprite sprite;
    protected int xGrid = 0, yGrid = 0;

    // constructor
    public SpriteViewer(Sprite sprite){
        this.sprite = sprite;
        sprite.setPixels(xGrid, yGrid);
    }

    // methods
    @Override
    public void draw(TextGraphics graphics, T model) {
        int x = model.getPosition().getX();
        int y = model.getPosition().getY();

        Color pixels[][] = sprite.getPixels();

        for (int i = 0; i < sprite.getHeight(); i++) {
            for (int j = 0; j < sprite.getWidth(); j++) {
                int R = pixels[i][j].getRed();
                int G = pixels[i][j].getGreen();
                int B = pixels[i][j].getBlue();

                // verificar se o pixel é transparente
                if (R == 131 && G == 131 && B == 131) {
                    continue;
                }

                graphics.setBackgroundColor(new TextColor.RGB(R, G, B));
                graphics.setCharacter(x + i, y + j, ' ');
            }
        }
    }

    public abstract void setSprite(ACTION action);
}
