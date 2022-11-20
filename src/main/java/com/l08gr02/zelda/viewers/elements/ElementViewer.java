package com.l08gr02.zelda.viewers.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.elements.Element;

public interface ElementViewer<T extends Element> {
    public void draw(T el, TextGraphics graphics);
}
