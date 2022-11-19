package com.l08gr02.zelda.viewer.game;

import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.model.game.elements.Link;
import com.l08gr02.zelda.model.game.elements.MovingElement;

public class LinkViewer implements ElementViewer<Link> {
    @Override
    public void draw(Link link, GUI gui){
        gui.drawLink(link.getPosition());
    }
}
