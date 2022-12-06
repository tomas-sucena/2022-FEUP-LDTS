package com.l08gr02.zelda.models.elements;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        Position p = (Position) obj;

        return (x == p.getX() && y == p.getY());
    }
}
