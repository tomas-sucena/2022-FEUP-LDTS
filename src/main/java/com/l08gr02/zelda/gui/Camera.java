package com.l08gr02.zelda.gui;

import com.l08gr02.zelda.models.elements.Hitbox;
import com.l08gr02.zelda.models.elements.Position;
import com.l08gr02.zelda.models.elements.moving.Mover;

public class Camera extends Mover {
    private Mover actor;
    private int xLim, yLim;

    // construtor
    public Camera(int x, int y, int tWidth, int tHeight) {
        super(x, y);
        hitbox = new Hitbox(x, y, tWidth, tHeight);

        xLim = x + tWidth;
        yLim = y + tHeight;
    }

    // métodos
    public void setActor(Mover actor){
        this.actor = actor;
    }

    public void film(){
        if (collidesWith(actor)){
            return;
        }

        // verificar se o ator passou os limites superiores
        if (actor.getHitbox().x + actor.getHitbox().width > xLim){
            hitbox.x += hitbox.width;
            xLim += hitbox.width;

            setPosition(new Position(hitbox.x, hitbox.y));
        }
        else if (actor.getHitbox().y + actor.getHitbox().height > yLim){
            hitbox.y += hitbox.height;
            yLim += hitbox.height;

            setPosition(new Position(hitbox.x, hitbox.y));
        }

        // verificar se o ator passou os limites inferiores
        if (actor.getHitbox().x < hitbox.x){
            hitbox.x -= hitbox.width;
            xLim -= hitbox.width;

            setPosition(new Position(hitbox.x, hitbox.y));
        }
        else if (actor.getHitbox().y < hitbox.y){
            hitbox.y -= hitbox.height;
            yLim -= hitbox.height;

            setPosition(new Position(hitbox.x, hitbox.y));
        }
    }

}
