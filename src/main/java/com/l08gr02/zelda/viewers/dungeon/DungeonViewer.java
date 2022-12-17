package com.l08gr02.zelda.viewers.dungeon;

import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.models.elements.tiles.AnimatedTile;
import com.l08gr02.zelda.models.elements.tiles.Heart;
import com.l08gr02.zelda.models.elements.tiles.StaticTile;
import com.l08gr02.zelda.viewers.Viewer;
import com.l08gr02.zelda.viewers.elements.*;

import java.util.List;

public class DungeonViewer implements Viewer<Dungeon> {
    private HeartViewer heartViewer;
    private StaticTileViewer staticTileViewer;
    private AnimatedTileViewer animatedTileViewer;

    // constructor
    public DungeonViewer(){
        heartViewer = new HeartViewer();
        animatedTileViewer = new AnimatedTileViewer();
    }

    // methods
    @Override
    public void draw(GUI gui, Dungeon dungeon) {
        drawStaticTiles(gui, dungeon.getStiles());
        drawAnimatedTiles(gui, dungeon.getAtiles());
        drawHearts(gui, dungeon);
    }

    public void drawAnimatedTiles(GUI gui, List<AnimatedTile> tiles) {
        for (AnimatedTile tile : tiles){
            if (gui.getCamera().collidesWith(tile)){
                animatedTileViewer.draw(gui, tile);
                animatedTileViewer.setSprite();
            }
        }
    }

    public void drawStaticTiles(GUI gui, List<StaticTile> tiles){
        for (StaticTile tile: tiles){
            if (gui.getCamera().collidesWith(tile)){
                staticTileViewer = new StaticTileViewer(tile.getSprite());
                staticTileViewer.draw(gui, tile);
            }
        }
    }

    public void drawHearts(GUI gui, Dungeon dungeon) {
        List<Heart> hearts = dungeon.getHearts();

        for (Heart heart: hearts) {
            if (gui.getCamera().collidesWith(heart)){
                heartViewer.draw(gui, heart);
            }
        }

        heartViewer.incrementHeartCount();
    }

}
