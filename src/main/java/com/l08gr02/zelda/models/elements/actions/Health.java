package com.l08gr02.zelda.models.elements.actions;

public interface Health {
    float getHearts();
    void setHearts(float hearts);
    void takeDamage(float heartsLost);
    void heal(float heartsGained);
}
