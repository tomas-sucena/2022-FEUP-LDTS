package com.l08gr02.zelda.presenters.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.elements.CollidingElement;
import com.l08gr02.zelda.models.elements.Hitbox;
import com.l08gr02.zelda.models.elements.moving.Mover;
import com.l08gr02.zelda.presenters.Presenter;
import com.l08gr02.zelda.viewers.Viewer;

import java.util.List;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public abstract class MoverPresenter<T extends Mover> extends Presenter<T> {
    // construtor
    public MoverPresenter(T model, Viewer<T> viewer){
        super(model, viewer);
    }

    // métodos
    public void moveUp() {
        Hitbox dummy = model.getHitbox().up(model.getSpeed());

        if (canMove(dummy)){
            model.up(model.getSpeed());
        }
    }

    public void moveDown() {
        Hitbox dummy = model.getHitbox().down(model.getSpeed());

        if (canMove(dummy)){
            model.down(model.getSpeed());
        }
    }

    public void moveLeft() {
        Hitbox dummy = model.getHitbox().left(model.getSpeed());

        if (canMove(dummy)){
            model.left(model.getSpeed());
        }
    }

    public void moveRight() {
        Hitbox dummy = model.getHitbox().right(model.getSpeed());

        if (canMove(dummy)){
            model.right(model.getSpeed());
        }
    }

    public boolean canMove(Hitbox dummy){
        for (CollidingElement el : model.getObstacles()){
            if (dummy.intersects(el.getHitbox())){
                return false;
            }
        }

        return true;
    }

    public abstract void update(TextGraphics graphics, List<ACTION> actions);
}
