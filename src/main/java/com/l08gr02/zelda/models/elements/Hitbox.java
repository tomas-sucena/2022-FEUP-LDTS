package com.l08gr02.zelda.models.elements;

import java.awt.*;

public class Hitbox extends Rectangle {
    // constructor
    public Hitbox(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    // method
    public Hitbox up(int i){
        return new Hitbox(x, y - i, width, height);
    }

    public Hitbox down(int i){
        return new Hitbox(x, y + i, width, height);
    }

    public Hitbox left(int i){
        return new Hitbox(x - i, y, width, height);
    }

    public Hitbox right(int i){
        return new Hitbox(x + i, y, width, height);
    }

    @Override
    public boolean intersects(Rectangle b) {
        int tw = this.width;
        int th = this.height;
        int bw = b.width;
        int bh = b.height;

        if (bw <= 0 || bh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }

        int tx = this.x;
        int ty = this.y;
        int bx = b.x;
        int by = b.y;
        bw += bx;
        bh += by;
        tw += tx;
        th += ty;
        //      overflow || intersect
        return ((bw <= bx || bw >= tx) &&
                (bh <= by || bh >= ty) &&
                (tw <= tx || tw >= bx) &&
                (th <= ty || th >= by));
    }

}
