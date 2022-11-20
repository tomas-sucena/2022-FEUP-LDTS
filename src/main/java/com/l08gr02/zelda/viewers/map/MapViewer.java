package com.l08gr02.zelda.viewers.map;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.viewers.elements.LinkViewer;

public class MapViewer {
    private TextGraphics graphics;
    private LinkViewer linkViewer;

    // constructor
    public MapViewer(TextGraphics graphics){
        this.graphics = graphics;
        linkViewer = new LinkViewer();
    }
}
