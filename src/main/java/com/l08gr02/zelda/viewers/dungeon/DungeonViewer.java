package com.l08gr02.zelda.viewers.dungeon;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.models.elements.AnimatedTile;
import com.l08gr02.zelda.models.elements.Heart;
import com.l08gr02.zelda.models.elements.StaticTile;
import com.l08gr02.zelda.models.elements.Tile;
import com.l08gr02.zelda.viewers.Viewer;
import com.l08gr02.zelda.viewers.elements.*;

import java.awt.*;
import java.util.List;

public class DungeonViewer implements Viewer<Dungeon> {
    private Sprite sprite;
    private int tWidth, tHeight;

    private LinkViewer linkViewer;
    private HeartViewer heartViewer;
    private StaticTileViewer staticTileViewer;
    private AnimatedTileViewer animatedTileViewer;
    private List<MonsterViewer> monsterViewers;

    // constructor
    public DungeonViewer(int tWidth, int tHeight){
        sprite = new Sprite(16, 16,"Dungeon", "Overworld");

        this.tWidth = tWidth; this.tHeight = tHeight;

        // criar os viewers
        linkViewer = new LinkViewer();
        heartViewer = new HeartViewer();
        animatedTileViewer = new AnimatedTileViewer();
    }

    // methods
    @Override
    public void draw(TextGraphics graphics, Dungeon dungeon) {
        drawStaticTiles(graphics, dungeon.getStiles());
        drawAnimatedTiles(graphics, dungeon.getAtiles());
        drawHearts(graphics, dungeon);
    }

    public void drawAnimatedTiles(TextGraphics graphics, List<AnimatedTile> tiles) {
        for (AnimatedTile tile : tiles){
            animatedTileViewer.draw(graphics, tile);
            animatedTileViewer.setSprite();
        }
    }
    public void drawStaticTiles(TextGraphics graphics, List<StaticTile> tiles){
        for(StaticTile tile: tiles){
            staticTileViewer = new StaticTileViewer(tile.getSprite());
            staticTileViewer.draw(graphics,tile);
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
