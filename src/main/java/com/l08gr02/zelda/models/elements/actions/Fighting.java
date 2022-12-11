package com.l08gr02.zelda.models.elements.actions;

public interface Fighting {
    void takeDamage(float heartsLost);
    void heal(float heartsGained);
    void attack();
}
