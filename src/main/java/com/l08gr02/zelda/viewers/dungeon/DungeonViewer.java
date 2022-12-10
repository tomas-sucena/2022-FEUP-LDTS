package com.l08gr02.zelda.viewers.dungeon;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.models.elements.Heart;
import com.l08gr02.zelda.models.elements.Tile;
import com.l08gr02.zelda.viewers.Viewer;
import com.l08gr02.zelda.viewers.elements.HeartViewer;
import com.l08gr02.zelda.viewers.elements.LinkViewer;
import com.l08gr02.zelda.viewers.elements.MonsterViewer;

import java.awt.*;
import java.util.List;

public class DungeonViewer implements Viewer<Dungeon> {
    private Sprite sprite;
    private int tWidth, tHeight;
    private LinkViewer linkViewer;
    private HeartViewer heartViewer;
    private List<MonsterViewer> monsterViewers;

    // constructor
    public DungeonViewer(int tWidth, int tHeight){
        sprite = new Sprite(16, 16,"Dungeon", "Overworld");

        this.tWidth = tWidth; this.tHeight = tHeight;

        // criar os viewers
        linkViewer = new LinkViewer();
        heartViewer = new HeartViewer();
    }

    // methods
    @Override
    public void draw(TextGraphics graphics, Dungeon dungeon) {
        drawTiles(graphics, dungeon.getTiles());
        drawHearts(graphics, dungeon);
    }

    public void drawTiles(TextGraphics graphics, List<Tile> tiles){
        for(Tile tile: tiles){
            int x = tile.getPosition().getX();
            int y = tile.getPosition().getY();
            Sprite tileSprite = tile.getSprite();
            Color[][] pixels = tileSprite.getPixels();
            for (int i = 0; i < tileSprite.getHeight(); i++) {
                for (int j = 0; j < tileSprite.getWidth(); j++) {
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

    public void drawHearts(TextGraphics graphics, Dungeon dungeon) {
        List<Heart> hearts = dungeon.getHearts();

        for (Heart heart: hearts) {
            heartViewer.draw(graphics, heart);
        }

        heartViewer.incrementHeartCount();
    }

    public LinkViewer getLinkViewer() {
        return linkViewer;
    }
}
