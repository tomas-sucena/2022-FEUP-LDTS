package com.l08gr02.zelda.models.elements.moving;

import com.l08gr02.zelda.models.elements.actions.Fighting;

public abstract class Fighter extends Mover implements Fighting {
    protected float hearts;
    protected int speed;

    // constructor
    public Fighter(int x, int y){
        super(x, y);
    }

    // methods
    public float getHearts(){
        return hearts;
    }

    public void takeDamage(float heartsLost) {
        hearts -= heartsLost;
    }

    public void heal(float heartsGained) {
        hearts += heartsGained;
    }

    public abstract void attack();
}
