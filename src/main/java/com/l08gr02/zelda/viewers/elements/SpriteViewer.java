package com.l08gr02.zelda.viewers.elements;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.gui.Camera;
import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.Element;

import java.awt.*;

public abstract class SpriteViewer<T extends Element> extends ElementViewer<T> {
    protected Sprite sprite;

    // constructor
    public SpriteViewer(Sprite sprite){
        this.sprite = sprite;
    }

    // methods
    @Override
    public void draw(GUI gui, T model) {
        if (!shouldDraw(gui, model)){
            return;
        }

        TextGraphics graphics = gui.getGraphics();
        Camera camera = gui.getCamera();

        int x = model.getPosition().getX() - camera.getPosition().getX();
        int y = model.getPosition().getY() - camera.getPosition().getY();

        Color[][] pixels = sprite.getPixels();

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

    public void drawt(GUI gui, T model) { //For testing purposes only
        TextGraphics graphics = gui.getGraphics();

        int x = model.getPosition().getX();
        int y = model.getPosition().getY();

        Color[][] pixels = sprite.getPixels();

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

}
