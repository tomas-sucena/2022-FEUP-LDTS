package com.l08gr02.zelda.viewers;

import com.l08gr02.zelda.gui.GUI;

public interface Viewer<T> {
    void draw(GUI gui, T model);
}
