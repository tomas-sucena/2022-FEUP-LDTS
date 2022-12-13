package com.l08gr02.zelda.viewers.dungeon;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.models.elements.tiles.AnimatedTile;
import com.l08gr02.zelda.models.elements.tiles.Heart;
import com.l08gr02.zelda.models.elements.tiles.StaticTile;
import com.l08gr02.zelda.gui.Camera;
import com.l08gr02.zelda.viewers.Viewer;
import com.l08gr02.zelda.viewers.elements.*;

import java.util.List;

public class DungeonViewer implements Viewer<Dungeon> {
    private Camera camera;
    private HeartViewer heartViewer;
    private StaticTileViewer staticTileViewer;
    private AnimatedTileViewer animatedTileViewer;

    // constructor
    public DungeonViewer(Camera camera){
        this.camera = camera;

        // criar os viewers
        heartViewer = new HeartViewer(camera);
        animatedTileViewer = new AnimatedTileViewer(camera);
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
            if (camera.collidesWith(tile)){
                animatedTileViewer.draw(graphics, tile);
                animatedTileViewer.setSprite();
            }
        }
    }

    public void drawStaticTiles(TextGraphics graphics, List<StaticTile> tiles){
        for (StaticTile tile: tiles){
            if (camera.collidesWith(tile)){
                staticTileViewer = new StaticTileViewer(tile.getSprite(), camera);
                staticTileViewer.draw(graphics, tile);
            }
        }
    }

    public void drawHearts(TextGraphics graphics, Dungeon dungeon) {
        List<Heart> hearts = dungeon.getHearts();

        for (Heart heart: hearts) {
            if (camera.collidesWith(heart)){
                heartViewer.draw(graphics, heart);
            }
        }

        heartViewer.incrementHeartCount();
    }

}
