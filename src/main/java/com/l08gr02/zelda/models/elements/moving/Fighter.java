package com.l08gr02.zelda.models.elements.moving;

import com.l08gr02.zelda.models.elements.Hitbox;
import com.l08gr02.zelda.models.elements.actions.Fighting;

public abstract class Fighter extends Creature implements Fighting {
    private Hitbox attackHitbox;

    // construtor
    public Fighter(int x, int y){
        super(x, y);
    }

    // methods
    public Hitbox getAttackHitbox() {
        return attackHitbox;
    }

    public void setAttackHitbox(Hitbox attackHitbox) {
        this.attackHitbox = attackHitbox;
    }

    @Override
    public abstract void attack();
}
