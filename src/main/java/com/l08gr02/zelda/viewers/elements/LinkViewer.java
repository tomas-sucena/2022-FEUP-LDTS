package com.l08gr02.zelda.viewers.elements;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.elements.Link;
import com.l08gr02.zelda.viewers.Viewer;

public class LinkViewer implements Viewer<Link> {
    @Override
    public void draw(TextGraphics graphics, Link link){
        int x = link.getPosition().getX(),
            y = link.getPosition().getY();

        graphics.setCharacter(x, y, TextCharacter.fromCharacter('L')[0]);
        graphics.putString(new TerminalPosition(x, y), "L");
    }
}
