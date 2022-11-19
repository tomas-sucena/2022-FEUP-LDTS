package com.l08gr02.zelda.viewers.elements;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.elements.Link;
import com.l08gr02.zelda.viewers.GameViewer;

public class LinkViewer implements ElementViewer<Link> {
    @Override
    public void draw(Link link, GameViewer gui){
        TextGraphics graphics = gui.getGraphics();
        int x = link.getPosition().getX(),
            y = link.getPosition().getY();

        graphics.setCharacter(x, y, TextCharacter.fromCharacter('L')[0]);
        graphics.putString(new TerminalPosition(x, y), "L");
    }
}
