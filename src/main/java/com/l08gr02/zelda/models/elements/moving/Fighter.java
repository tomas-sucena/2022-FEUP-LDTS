package com.l08gr02.zelda.models.elements.moving;

public abstract class Fighter extends MovingElement implements Fight {
    protected float hearts;

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
