package com.l08gr02.zelda.viewers;

import com.googlecode.lanterna.graphics.TextGraphics;

public interface Viewer<T> {
    void draw(TextGraphics graphics, T model);
}
