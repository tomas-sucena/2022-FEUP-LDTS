package com.l08gr02.zelda.models.elements.moving;

import com.l08gr02.zelda.models.elements.actions.Fighting;

public abstract class Fighter extends Mover implements Fighting {
    private float hearts;

    // construtor
    public Fighter(int x, int y){
        super(x, y);
    }

    // métodos
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

    @Override
    public abstract void attack();
}
