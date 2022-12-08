package com.l08gr02.zelda.viewers.dungeon;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.models.elements.Element;
import com.l08gr02.zelda.viewers.Viewer;
import com.l08gr02.zelda.viewers.elements.LinkViewer;
import com.l08gr02.zelda.viewers.elements.MonsterViewer;

import java.util.List;

public class DungeonViewer implements Viewer<Dungeon> {
    private Sprite sprite;
    private int tWidth, tHeight;
    private LinkViewer linkViewer;
    private List<MonsterViewer> monsterViewers;

    // constructor
    public DungeonViewer(int tWidth, int tHeight){
        sprite = new Sprite(16, 16,"Dungeon", "Overworld");

        this.tWidth = tWidth; this.tHeight = tHeight;

        // criar os viewers
        linkViewer = new LinkViewer();


    }

    // methods
    @Override
    public void draw(TextGraphics graphics, Dungeon dungeon){
        for (Element el : dungeon.getTiles()){

        }
    }

    public LinkViewer getLinkViewer() {
        return linkViewer;
    }
}
