package com.l08gr02.zelda.models.elements.actions;

public interface Fighting {
    float getHearts();
    void setHearts(float hearts);
    void takeDamage(float heartsLost);
    void heal(float heartsGained);
    void attack();
}
