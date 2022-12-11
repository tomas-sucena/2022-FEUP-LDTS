package com.l08gr02.zelda.models.elements.moving;

public interface Fight {
    void takeDamage(float heartsLost);
    void heal(float heartsGained);
    void attack();
}
