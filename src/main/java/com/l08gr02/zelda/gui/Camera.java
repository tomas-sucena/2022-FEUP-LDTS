package com.l08gr02.zelda.gui;

import com.l08gr02.zelda.models.elements.Element;
import com.l08gr02.zelda.models.elements.Hitbox;
import com.l08gr02.zelda.models.elements.Position;
import com.l08gr02.zelda.models.elements.moving.Mover;

import java.util.LinkedList;
import java.util.Queue;

public class Camera extends Element {
    private Mover actor;
    private int tWidth, tHeight;
    //private Queue<Hitbox> photoshoot;

    // construtor
    public Camera(int x, int y, int tWidth, int tHeight) {
        super(x, y);
        setHitbox(new Hitbox(x, y, tWidth, tHeight));

        this.tWidth = tWidth;
        this.tHeight = tHeight;

        //photoshoot = new LinkedList<>();
    }

    // métodos
    public void setActor(Mover actor){
        this.actor = actor;

        film();
    }

    public void film(){
        Hitbox actorHitbox = actor.getHitbox();

        int x = actorHitbox.x - tWidth / 2;
        int y = actorHitbox.y - tHeight / 2;

        // evitar que a câmara filme fora do mapa
        if (x < 0 || y < 0){
            return;
        }

        setPosition(new Position(x, y));
        hitbox.setLocation(x, y);
    }

    /* câmara dinâmica
    public void setActor(Mover actor){
        this.actor = actor;

        photoshoot.add(actor.getHitbox());
        followActor();
    }

    private void followActor(){
        int x = photoshoot.peek().x - tWidth / 2;
        int y = photoshoot.poll().y - tHeight / 2;

        setPosition(new Position(x, y));
        getHitbox().setLocation(x, y);
    }

    public void film(){
        photoshoot.add(actor.getHitbox());

        if (photoshoot.size() >= 20){
            followActor();
        }
    }*/

}
