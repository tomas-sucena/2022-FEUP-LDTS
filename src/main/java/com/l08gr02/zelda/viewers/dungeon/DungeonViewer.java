package com.l08gr02.zelda.viewers.dungeon;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.models.elements.Heart;
import com.l08gr02.zelda.models.elements.Tile;
import com.l08gr02.zelda.viewers.Viewer;
import com.l08gr02.zelda.viewers.elements.LinkViewer;
import com.l08gr02.zelda.viewers.elements.MonsterViewer;

import java.awt.*;
import java.util.List;

public class DungeonViewer implements Viewer<Dungeon> {
    private Sprite sprite;
    private Sprite heart;
    private int tWidth, tHeight;
    private int heartCount = 0;
    private LinkViewer linkViewer;
    private List<MonsterViewer> monsterViewers;
    // constructor
    public DungeonViewer(int tWidth, int tHeight){
        sprite = new Sprite(16, 16,"Dungeon", "Overworld");
        heart = new Sprite(16,16,"gfx","objects");

        this.tWidth = tWidth; this.tHeight = tHeight;

        // criar os viewers
        linkViewer = new LinkViewer();

        //monsterviewers = new MonsterViewer();
    }

    // methods
    @Override
    public void draw(TextGraphics graphics, Dungeon dungeon){
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
        heart.setPixels(heartCount + 4, 8);
        heartCount++;
        if (heartCount == 4) {
            heartCount = 0;
        }
        Color pixels[][] = heart.getPixels();
        List<Heart> hearts = dungeon.getHearts();

        for (int k = 0; k < hearts.size(); k++) {
            int x = hearts.get(k).getPosition().getX();
            int y = hearts.get(k).getPosition().getY();
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

    public LinkViewer getLinkViewer() {
        return linkViewer;
    }

    public List<MonsterViewer> getMonsterViewer() {
        return monsterViewers;
    }
}
