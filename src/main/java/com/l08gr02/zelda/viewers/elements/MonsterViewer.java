package com.l08gr02.zelda.viewers.elements;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.elements.Monster;
import com.l08gr02.zelda.models.elements.MovingElement;
import com.l08gr02.zelda.viewers.Viewer;

public class MonsterViewer implements Viewer<Monster> {
    // method
    @Override
    public void draw(TextGraphics graphics, Monster monster) {
        int x = monster.getPosition().getX();
        int y =  monster.getPosition().getY();

        graphics.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);

        graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(x, y), "T");
    }
}
