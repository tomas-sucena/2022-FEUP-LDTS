package com.l08gr02.zelda.viewers.elements;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.Link;
import com.l08gr02.zelda.viewers.SpriteViewer;

import java.awt.*;
import java.util.Map;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;
import static java.util.Map.entry;

public class LinkViewer extends SpriteViewer<Link> {
    private Sprite heartSprite;
    private ACTION direction;
    private final static Map<ACTION, Integer> attackYs = Map.ofEntries(
            entry(ACTION.UP, 5),
            entry(ACTION.DOWN, 4),
            entry(ACTION.LEFT, 6),
            entry(ACTION.RIGHT, 7)
    );
    private boolean attacking;

    // constructor
    public LinkViewer(){
        super(new Sprite(44, 44, "Link", "spritesheet"));

        heartSprite = new Sprite(16, 16,"gfx","objects");

        direction = ACTION.DOWN;
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
            case UP -> {
                yGrid = 1;
                xGrid = (xGrid >= 7) ? 0 : xGrid + 1;
                setDirection(action);
            }

            case DOWN -> {
                yGrid = 0;
                xGrid = (xGrid >= 7) ? 0 : xGrid + 1;
                setDirection(action);
            }

            case LEFT -> {
                yGrid = 2;
                xGrid = (xGrid >= 5) ? 0 : xGrid + 1;
                setDirection(action);
            }

            case RIGHT -> {
                yGrid = 3;
                xGrid = (xGrid >= 5) ? 0 : xGrid + 1;
                setDirection(action);
            }

            case ATTACK -> {yGrid = attackYs.get(direction);}
        }

        sprite.setPixels(xGrid, yGrid);
    }

    public void setDirection(ACTION direction){
        this.direction = direction;
    }

}
