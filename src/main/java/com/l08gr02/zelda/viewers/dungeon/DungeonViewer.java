package com.l08gr02.zelda.viewers.dungeon;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.viewers.Viewer;
import com.l08gr02.zelda.viewers.elements.LinkViewer;

public class DungeonViewer implements Viewer<Dungeon> {
    private LinkViewer linkViewer;

    // constructor
    public DungeonViewer(){
        linkViewer = new LinkViewer();
    }

    // methods
    @Override
    public void draw(Screen screen, Dungeon dungeon){
        linkViewer.draw(screen, dungeon.getLink());
    }

    public LinkViewer getLinkViewer() {
        return linkViewer;
    }
}
