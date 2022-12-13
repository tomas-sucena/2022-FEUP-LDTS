package com.l08gr02.zelda.models.elements;

public abstract class Element {
    private Position pos;
    protected Hitbox hitbox;

    // construtor
    public Element(int x, int y){
        pos = new Position(x, y);
    }

    // métodos
    public Position getPosition(){
        return pos;
    }

    public void setPosition(Position pos){
        this.pos = pos;
    }

    public Hitbox getHitbox() {
        return hitbox;
    }

    public void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
    }

    public boolean collidesWith(Element el){
        return hitbox.intersects(el.getHitbox());
    }

}
