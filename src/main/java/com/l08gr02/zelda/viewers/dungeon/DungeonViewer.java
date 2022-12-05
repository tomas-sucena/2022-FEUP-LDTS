package com.l08gr02.zelda.viewers.dungeon;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.viewers.Viewer;
import com.l08gr02.zelda.viewers.elements.LinkViewer;
import com.l08gr02.zelda.viewers.elements.MonsterViewer;
import com.l08gr02.zelda.viewers.elements.TileViewer;

import java.util.List;

public class DungeonViewer implements Viewer<Dungeon> {
    private Sprite sprite;
    private int tWidth, tHeight;
    private LinkViewer linkViewer;

    // constructor
    public DungeonViewer(int tWidth, int tHeight){
        sprite = new Sprite(16, "Dungeon", "Overworld");

        this.tWidth = tWidth; this.tHeight = tHeight;

        linkViewer = new LinkViewer();
    }

    // methods
    @Override
    public void draw(TextGraphics graphics, Dungeon dungeon){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0),
                new TerminalSize(tWidth, tHeight), ' ');
    }

    public LinkViewer getLinkViewer() {
        return linkViewer;
    }
}
