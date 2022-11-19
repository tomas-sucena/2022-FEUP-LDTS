package com.l08gr02.zelda.gui;

import com.l08gr02.zelda.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawWall(Position position);

    void drawLink(Position position);

    void drawMonster(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;








    enum ACTION {UP, DOWN, LEFT, RIGHT, NONE, QUIT, SELECT}
}
