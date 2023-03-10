package com.l08gr02.zelda.gui;

import com.l08gr02.zelda.models.elements.Element;
import com.l08gr02.zelda.models.elements.Hitbox;
import com.l08gr02.zelda.models.elements.Position;
import com.l08gr02.zelda.models.elements.moving.Mover;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Camera extends Element {
    private Mover actor;
    private final int tWidth, tHeight, TILE_SIZE;
    private int xLim, yLim;
    private final Queue<Hitbox> photoshoot;

    // constructor
    public Camera(int x, int y, int tWidth, int tHeight, int TILE_SIZE) {
        super(x, y);
        setHitbox(new Hitbox(x, y, tWidth, tHeight));

        this.tWidth = tWidth;
        this.tHeight = tHeight;
        this.TILE_SIZE = TILE_SIZE;

        photoshoot = new ArrayDeque<>();
    }

    // methods
    public void setLimits(List<String> map){
        this.xLim = map.get(0).length() * TILE_SIZE;
        this.yLim = map.size() * TILE_SIZE;
    }

    public void setActor(Mover actor){
        this.actor = actor;

        photoshoot.add(actor.getHitbox());
        followActor();
    }

    private void followActor(){
        Hitbox photo = photoshoot.remove();

        // define new x value
        int nextX = photo.x - tWidth / 2;
        int currX = getPosition().getX();

        nextX = (nextX < 0 || nextX + tWidth > xLim) ? currX : nextX;

        // define new y value
        int nextY = photo.y - tHeight / 2;
        int currY = getPosition().getY();

        nextY = (nextY < 0 || nextY + tHeight > yLim) ? currY : nextY;

        // define new camera position
        setPosition(new Position(nextX, nextY));
        getHitbox().setLocation(nextX, nextY);
    }

    public void film(){
        photoshoot.add(actor.getHitbox());

        if (photoshoot.size() >= 2){
            followActor();
        }
    }

}
