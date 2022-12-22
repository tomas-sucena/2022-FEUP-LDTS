package com.l08gr02.zelda.viewers.elements;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.moving.Link;
import com.l08gr02.zelda.viewers.SpriteViewer;

import java.awt.*;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public class LinkViewer extends SpriteViewer<Link> {
    private final Sprite heartSprite;
    private boolean attacking;

    // constructor
    public LinkViewer(){
        super(new Sprite(44, 44, "Link", "spritesheet"));

        heartSprite = new Sprite(16, 16,"gfx","objects");
    }

    // methods
    public boolean isAttacking() {
        return attacking;
    }

    @Override
    public void draw(GUI gui, Link link) {
        super.draw(gui, link);

        drawHealthBar(gui, link);
    }

    public void drawHealthBar(GUI gui, Link link){
        heartSprite.setPixels(4,0);

        float life = link.getHearts();

        // draw all whole hearts
        for (int i = 0; i < (int) life; i++){
            drawHeart(gui, i);
        }

        // draw the fragmented heart, if it exists
        if (life % 1 != 0){
            heartSprite.setPixels(8 - (int) (life % 1 * 4),0);
            drawHeart(gui, (int) life);
        }
    }

    public void drawHeart(GUI gui, int n){
        TextGraphics graphics = gui.getGraphics();
        Color[][] pixels = heartSprite.getPixels();

        for (int i = 0; i < heartSprite.getHeight(); i++) {
            for (int j = 0; j < heartSprite.getWidth(); j++) {
                int R = pixels[i][j].getRed();
                int G = pixels[i][j].getGreen();
                int B = pixels[i][j].getBlue();

                // verify if the pixel is transparent
                if (R == 131 && G == 131 && B == 131) {
                    continue;
                }

                graphics.setBackgroundColor(new TextColor.RGB(R, G, B));
                graphics.setCharacter(n * 16 + i, j, ' ');
            }
        }
    }

    @Override
    public void setSprite(ACTION action){
        switch (action) {
            case UP -> {
                yGrid = 1;
                xGrid = (xGrid >= 7) ? 0 : xGrid + 1;
            }

            case DOWN -> {
                yGrid = 0;
                xGrid = (xGrid >= 7) ? 0 : xGrid + 1;
            }

            case LEFT -> {
                yGrid = 2;
                xGrid = (xGrid >= 5) ? 0 : xGrid + 1;
            }

            case RIGHT -> {
                yGrid = 3;
                xGrid = (xGrid >= 5) ? 0 : xGrid + 1;
            }

            case ATTACK -> {
                if (!attacking){
                    attacking = true;

                    yGrid += 4;
                    xGrid = -1;
                }

                if (xGrid < 4){
                    xGrid++;
                }
                else{
                    attacking = false;

                    yGrid -= 4;
                    xGrid = 0;
                }
            }
        }

        sprite.setPixels(xGrid, yGrid);
    }

}
