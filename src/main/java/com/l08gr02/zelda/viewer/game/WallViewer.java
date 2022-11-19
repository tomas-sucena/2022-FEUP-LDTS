package com.l08gr02.zelda.viewer.game;

import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.model.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall w, GUI gui){
        gui.drawWall(w.getPosition());
    }
}
