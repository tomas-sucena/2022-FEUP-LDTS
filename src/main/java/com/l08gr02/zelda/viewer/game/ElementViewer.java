package com.l08gr02.zelda.viewer.game;

import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.model.game.elements.Element;

public interface ElementViewer<T extends Element>{
    void draw(T el, GUI gui);
}
