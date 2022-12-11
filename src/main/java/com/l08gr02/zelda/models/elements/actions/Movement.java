package com.l08gr02.zelda.models.elements.actions;

public interface Movement {
    int getSpeed();
    void setSpeed(int speed);
    void up(int i);
    void down(int i);
    void left(int i);
    void right(int i);
}
