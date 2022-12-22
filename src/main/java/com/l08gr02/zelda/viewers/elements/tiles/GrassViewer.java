package com.l08gr02.zelda.viewers.elements.tiles;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.gui.Camera;
import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.elements.Position;
import com.l08gr02.zelda.models.elements.tiles.Grass;
import com.l08gr02.zelda.viewers.elements.ElementViewer;

public class GrassViewer extends ElementViewer<Grass> {
    // method
    @Override
    public void draw(GUI gui, Grass grass){
        TextGraphics graphics = gui.getGraphics();
        Camera camera = gui.getCamera();

        int x = grass.getPosition().getX() - camera.getPosition().getX();
        int y = grass.getPosition().getY() - camera.getPosition().getY();

        graphics.setBackgroundColor(TextColor.Factory.fromString("#3ABE41"));
        graphics.fillRectangle(new TerminalPosition(x, y),
                new TerminalSize(16, 16), ' ');

        // draw the grass texture
        drawTexture(graphics, new Position(x + 4, y + 4));
        drawTexture(graphics, new Position(x + 7, y + 12));

        graphics.setBackgroundColor(TextColor.Factory.fromString("#6ADD4B"));
        graphics.fillRectangle(new TerminalPosition(x + 1, y + 11),
                new TerminalSize(1, 1), ' ');
        graphics.fillRectangle(new TerminalPosition(x + 14, y + 3),
                new TerminalSize(1, 2), ' ');

        graphics.setBackgroundColor(TextColor.Factory.fromString("#29973B"));
        graphics.fillRectangle(new TerminalPosition(x + 14, y + 5),
                new TerminalSize(1, 1), ' ');
    }

    public void drawTexture(TextGraphics graphics, Position pos){
        int x = pos.getX();
        int y = pos.getY();

        graphics.setBackgroundColor(TextColor.Factory.fromString("#6ADD4B"));
        graphics.fillRectangle(new TerminalPosition(x, y),
                new TerminalSize(1, 3), ' ');
        graphics.fillRectangle(new TerminalPosition(x + 2, y + 1),
                new TerminalSize(1, 2), ' ');
        graphics.fillRectangle(new TerminalPosition(x + 3, y),
                new TerminalSize(1, 1), ' ');

        // draw the shadows
        graphics.setBackgroundColor(TextColor.Factory.fromString("#29973B"));
        graphics.fillRectangle(new TerminalPosition(x, y + 3),
                new TerminalSize(1, 1), ' ');
        graphics.fillRectangle(new TerminalPosition(x + 2, y + 3),
                new TerminalSize(1, 1), ' ');
        graphics.fillRectangle(new TerminalPosition(x + 3, y + 1),
                new TerminalSize(1, 1), ' ');
    }
}
