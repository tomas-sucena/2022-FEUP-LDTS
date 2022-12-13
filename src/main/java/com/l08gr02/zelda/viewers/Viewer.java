package com.l08gr02.zelda.viewers;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.gui.Camera;

public interface Viewer<T> {
    void draw(TextGraphics graphics, T model);
}
