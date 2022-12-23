package com.l08gr02.zelda.models.elements.moving;

import com.l08gr02.zelda.models.elements.actions.Health;

public abstract class Creature extends Mover implements Health {
    private float hearts;

    // constructor
    public Creature(int x, int y){
        super(x, y);
    }

    // methods
    @Override
    public float getHearts(){
        return hearts;
    }

    @Override
    public void setHearts(float hearts){
        this.hearts = hearts;
    }

    @Override
    public void takeDamage(float heartsLost) {
        hearts -= heartsLost;
    }

    @Override
    public void heal(float heartsGained) {
        hearts += heartsGained;
    }

}
