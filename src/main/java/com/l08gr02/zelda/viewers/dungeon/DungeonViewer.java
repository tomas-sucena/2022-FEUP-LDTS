package com.l08gr02.zelda.viewers.dungeon;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.models.elements.tiles.AnimatedTile;
import com.l08gr02.zelda.models.elements.tiles.Heart;
import com.l08gr02.zelda.models.elements.tiles.StaticTile;
import com.l08gr02.zelda.viewers.Viewer;
import com.l08gr02.zelda.viewers.elements.*;

import java.util.List;

public class DungeonViewer implements Viewer<Dungeon> {
    private int tWidth, tHeight;
    private LinkViewer linkViewer;
    private HeartViewer heartViewer;
    private StaticTileViewer staticTileViewer;
    private AnimatedTileViewer animatedTileViewer;
    private List<MonsterViewer> monsterViewers;

    // constructor
    public DungeonViewer(int tWidth, int tHeight){
        this.tWidth = tWidth; this.tHeight = tHeight;

        // criar os viewers
        linkViewer = new LinkViewer();
        heartViewer = new HeartViewer();
        animatedTileViewer = new AnimatedTileViewer();
    }

    // methods
    public LinkViewer getLinkViewer() {
        return linkViewer;
    }

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
    
}
