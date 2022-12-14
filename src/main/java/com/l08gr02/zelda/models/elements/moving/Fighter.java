package com.l08gr02.zelda.models.elements.moving;

import com.l08gr02.zelda.models.elements.Hitbox;
import com.l08gr02.zelda.models.elements.actions.Fighting;

public abstract class Fighter extends Mover implements Fighting {
    private float hearts;
    private boolean attacking;
    private Hitbox attackHitbox;

    // construtor
    public Fighter(int x, int y){
        super(x, y);

        attacking = false;
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

    public Hitbox getAttackHitbox() {
        return attackHitbox;
    }

    public void setAttackHitbox(Hitbox attackHitbox) {
        this.attackHitbox = attackHitbox;
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
    public boolean isAttacking() {
        return attacking;
    }

    @Override
    public void attack(){
        attacking = true;
    }
}
