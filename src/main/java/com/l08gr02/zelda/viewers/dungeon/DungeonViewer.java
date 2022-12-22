package com.l08gr02.zelda.viewers.dungeon;

import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.models.elements.Element;
import com.l08gr02.zelda.models.elements.tiles.Grass;
import com.l08gr02.zelda.models.elements.tiles.Heart;
import com.l08gr02.zelda.viewers.Viewer;
import com.l08gr02.zelda.viewers.elements.HeartViewer;
import com.l08gr02.zelda.viewers.elements.tiles.GrassViewer;

public class DungeonViewer implements Viewer<Dungeon> {
    private GrassViewer grassViewer;
    private HeartViewer heartViewer;

    // constructor
    public DungeonViewer(){
        grassViewer = new GrassViewer();
        heartViewer = new HeartViewer();
    }

    // methods
    @Override
    public void draw(GUI gui, Dungeon dungeon) {
        for (Element tile : dungeon.getTiles()){
            grassViewer.draw(gui, (Grass) tile);
        }

        for (Heart heart : dungeon.getHearts()){
            heartViewer.draw(gui, heart);
            heartViewer.incrementHeartCount();
        }
    }

}
