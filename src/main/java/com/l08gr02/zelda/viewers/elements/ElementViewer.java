package com.l08gr02.zelda.viewers.elements;

import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.elements.Element;
import com.l08gr02.zelda.viewers.Viewer;

public abstract class ElementViewer<T extends Element> implements Viewer<T> {
    // methods
    public boolean shouldDraw(GUI gui, T element){
        return gui.getCamera().collidesWith(element);
    }

    @Override
    public abstract void draw(GUI gui, T model);
}
