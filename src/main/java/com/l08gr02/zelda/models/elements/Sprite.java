package com.l08gr02.zelda.models.elements;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

    private static BufferedImage spriteSheet;
    private static final int TILE_SIZE = 32;

    public static BufferedImage loadSprite(String type,String file) {

        BufferedImage sprite = null;

        try {
            sprite = ImageIO.read(new File("../../../../resources/models/" + type + "/" + file + ".png"));
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

}
