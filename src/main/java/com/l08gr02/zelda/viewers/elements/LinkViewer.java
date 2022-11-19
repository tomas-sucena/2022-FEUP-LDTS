package com.l08gr02.zelda.viewers.elements;

import com.l08gr02.zelda.models.elements.Link;
import com.l08gr02.zelda.viewers.GameViewer;

public class LinkViewer implements ElementViewer<Link> {
    @Override
    public void draw(Link link, GameViewer gui){
        gui.drawLink(link.getPosition());
    }
}
