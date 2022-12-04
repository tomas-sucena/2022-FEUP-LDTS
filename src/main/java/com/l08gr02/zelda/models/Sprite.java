package com.l08gr02.zelda.models;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
    private final BufferedImage spriteSheet;
    private final int TILE_SIZE;

    private int width, height;

    private Color[][] pixels;

    // constructor
    public Sprite(int TILE_SIZE, String type, String file){
        this.TILE_SIZE = TILE_SIZE;
        spriteSheet = loadSprite(type, file);
    }

    // methods
    public BufferedImage loadSprite(String type, String file) {
        BufferedImage sprite = null;

        try {
            sprite = ImageIO.read(new File("src/main/resources/models/" + type + "/" + file + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sprite;
    }

    public BufferedImage getSprite(int xGrid, int yGrid) {
        return spriteSheet.getSubimage(xGrid * TILE_SIZE, yGrid * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }

    public void setPixels(int xGrid, int yGrid){
        BufferedImage sprite = getSprite(xGrid, yGrid);
        height = sprite.getHeight();
        width = sprite.getWidth();
        pixels = new Color[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                pixels[i][j] = new Color(sprite.getRGB(i,j));
            }
        }
    }

    public Color[][] getPixels() {
        return pixels;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
