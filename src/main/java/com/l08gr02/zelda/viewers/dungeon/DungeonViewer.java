package com.l08gr02.zelda.viewers.dungeon;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.Terminal;
import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.viewers.Viewer;
import com.l08gr02.zelda.viewers.elements.LinkViewer;

public class DungeonViewer implements Viewer<Dungeon> {
    private int tWidth, tHeight;
    private LinkViewer linkViewer;

    // constructor
    public DungeonViewer(int tWidth, int tHeight){
        this.tWidth = tWidth; this.tHeight = tHeight;

        linkViewer = new LinkViewer();
    }

    // methods
    @Override
    public void draw(TextGraphics graphics, Dungeon dungeon){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0),
                new TerminalSize(tWidth, tHeight), ' ');

        linkViewer.draw(graphics, dungeon.getLink());
    }

    public LinkViewer getLinkViewer() {
        return linkViewer;
    }
}
