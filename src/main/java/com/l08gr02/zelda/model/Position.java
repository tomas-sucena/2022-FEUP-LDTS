package com.l08gr02.zelda.model;

public class Position {
    private final int x, y;

    // constructor
    public Position(int x, int y){
        this.x = x; this.y = y;
    }

    // methods
    public int getX(){
        return x;
    }

    public int getY(){
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

    @Override
    public boolean equals(Object o){
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        Position p = (Position) o;

        return (this.x == p.getX() && this.y == p.getY());
    }

}
