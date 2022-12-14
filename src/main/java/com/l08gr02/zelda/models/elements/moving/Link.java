package com.l08gr02.zelda.models.elements.moving;

import com.l08gr02.zelda.models.elements.Hitbox;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public class Link extends Fighter {
    private static int WALK_SPEED = 2, SPRINT_SPEED = 4;

    // construtor
    public Link(int x, int y){
        super(x, y);
        setHitbox(new Hitbox(x + 15, y + 24, 14, 10));

        setHearts(3);
        setDirection(ACTION.DOWN);
    }

    // métodos
    public void walk(){
        setSpeed(WALK_SPEED);
    }

    public void sprint(){
        setSpeed(SPRINT_SPEED);
    }

    @Override
    public void attack() {
        super.attack();

        // definir a hitbox da espada
        Hitbox swordHitbox = null;

        int x = getPosition().getX();
        int y = getPosition().getY();

        switch (getDirection()){
            case UP -> {swordHitbox = new Hitbox(x + 4, y + 4, 38, 8);}

            case DOWN -> {swordHitbox = new Hitbox(x, y + 36, 44, 8);}

            case LEFT -> {swordHitbox = new Hitbox(x, y, 8, 44);}

            case RIGHT -> {swordHitbox = new Hitbox(x + 36, y, 8, 44);}
        }

        setAttackHitbox(swordHitbox);
    }

}
