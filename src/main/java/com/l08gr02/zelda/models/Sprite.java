package com.l08gr02.zelda.models;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
    private static BufferedImage spriteSheet;
    private static final int TILE_SIZE = 24;

    private int height;

    private int width;

    private Color[][] pixels;

    // methods
    public static BufferedImage loadSprite(String type, String file) {
        BufferedImage sprite = null;

        try {
            sprite = ImageIO.read(new File("src/main/resources/models/" + type + "/" + file + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sprite;
    }

    public static BufferedImage getSprite(int xGrid, int yGrid, String type, String file) {

        if (spriteSheet == null) {
            spriteSheet = loadSprite(type,file);
        }

        return spriteSheet.getSubimage(xGrid * TILE_SIZE, yGrid * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }

    public void setPixels(int xGrid, int yGrid, String type, String file){
        BufferedImage sprite = getSprite(xGrid, yGrid, type, file);
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
