package com.l08gr02.zelda.viewers.elements;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.Link;
import com.l08gr02.zelda.viewers.SpriteViewer;

import java.awt.*;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public class LinkViewer extends SpriteViewer<Link> {
    private Sprite heartSprite;

    // constructor
    public LinkViewer(){
        super(new Sprite(44, 44, "Link", "spritesheet"));

        heartSprite = new Sprite(16, 16,"gfx","objects");
    }

    // methods
    @Override
    public void draw(TextGraphics graphics, Link link) {
        super.draw(graphics, link);

        drawHealthBar(graphics, link);
    }

    public void drawHealthBar(TextGraphics graphics, Link link){
        heartSprite.setPixels(4,0);

        float life = link.getHearts();

        // desenhar os corações inteiros
        for (int i = 0; i < (int) life; i++){
            drawHeart(graphics, i);
        }

        // desenhar o coração não inteiro, caso exista
        if (life % 1 != 0){
            heartSprite.setPixels(8 - (int) (life % 1 * 4),0);
            drawHeart(graphics, (int) life);
        }
    }

    public void drawHeart(TextGraphics graphics, int n){
        Color[][] pixels = heartSprite.getPixels();

        for (int i = 0; i < heartSprite.getHeight(); i++) {
            for (int j = 0; j < heartSprite.getWidth(); j++) {
                int R = pixels[i][j].getRed();
                int G = pixels[i][j].getGreen();
                int B = pixels[i][j].getBlue();

                // verificar se o pixel é transparente
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
            case UP -> {yGrid = 1;}

            case DOWN -> {yGrid = 0;}

            case LEFT -> {yGrid = 2;}

            case RIGHT -> {yGrid = 3;}

            case ATTACK -> {yGrid = 4;}
        }

        if (xGrid == 5){
            xGrid = 0;
        }
        else if (action != ACTION.NOTHING && action != ACTION.SPRINT){
            xGrid++;
        }

        sprite.setPixels(xGrid, yGrid);
    }

}
