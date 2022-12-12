package com.l08gr02.zelda.models.elements;

import java.util.Random;

public class Position {
    private final int x, y;

    // constructors
    public Position(int x, int y){
        this.x = x; this.y = y;
    }

    public Position(Position pos){
        this.x=pos.getX();
        this.y=pos.getY();
    }

    // methods
    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public Position up(int i){
        return new Position(x, y - i);
    }

    public Position down(int i){
        return new Position(x, y + i);
    }

    public Position left(int i){
        return new Position(x - i, y);
    }

    public Position right(int i){
        return new Position(x + i, y);
    }

    public Position getRandomNeighbour(){
        Random rnd = new Random();
        int genMove = rnd.nextInt(4);
        Position newpos = new Position(this.x,this.y);
        switch(genMove){
            case 0 -> newpos.up(1);
            case 1 -> newpos.down(1);
            case 2 -> newpos.left(1);
            case 3 -> newpos.right(1);
            }
        return newpos;
    }

    public boolean isEmpty(){
        return true;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        Position p = (Position) obj;

        return (x == p.getX() && y == p.getY());
    }
}
