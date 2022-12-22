package com.l08gr02.zelda.models.elements.moving.monsters;

import com.l08gr02.zelda.models.elements.Hitbox;

public class Log extends Monster {
    private Hitbox sleepZone;

    // constructor
    public Log(int x, int y){
        super(x, y);
        setHitbox(new Hitbox(x + 8, y + 12, 16, 16));
        setSleepZone(new Hitbox(x - 8, y - 8, 48, 48));

        // define the stats
        setHearts(2);
        WALK_SPEED = 3;

        setSpeed(WALK_SPEED);
    }

    // methods
    public Hitbox getSleepZone() {
        return sleepZone;
    }

    public void setSleepZone(Hitbox sleepZone) {
        this.sleepZone = sleepZone;
    }

    @Override
    public void up(int i){
        super.up(i);

        setSleepZone(getSleepZone().up(i));
    }
    @Override
    public void down(int i){
        super.down(i);

        setSleepZone(getSleepZone().down(i));
    }

    @Override
    public void left(int i){
        super.left(i);
        setSleepZone(getSleepZone().left(i));
    }

    @Override
    public void right(int i){
        super.right(i);

        setSleepZone(getSleepZone().right(i));
    }

    @Override
    public void attack() {
    }

}
