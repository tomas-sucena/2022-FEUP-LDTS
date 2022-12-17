package com.l08gr02.zelda.presenters.elements;

import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.elements.CollidingElement;
import com.l08gr02.zelda.models.elements.Hitbox;
import com.l08gr02.zelda.models.elements.moving.Mover;
import com.l08gr02.zelda.presenters.Presenter;
import com.l08gr02.zelda.viewers.Viewer;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public abstract class MoverPresenter<T extends Mover> extends Presenter<T> {
    // construtor
    public MoverPresenter(T model, Viewer<T> viewer){
        super(model, viewer);
    }

    // métodos
    public void moveUp(int speed) {
        model.setDirection(ACTION.UP);

        // verificar se o modelo se pode mover sem colidir
        Hitbox dummy = model.getHitbox().up(speed);

        if (canMove(dummy)){
            model.up(speed);
        }
    }

    public void moveDown(int speed) {
        model.setDirection(ACTION.DOWN);

        // verificar se o modelo se pode mover sem colidir
        Hitbox dummy = model.getHitbox().down(speed);

        if (canMove(dummy)){
            model.down(speed);
        }
    }

    public void moveLeft(int speed) {
        model.setDirection(ACTION.LEFT);

        // verificar se o modelo se pode mover sem colidir
        Hitbox dummy = model.getHitbox().left(speed);

        if (canMove(dummy)){
            model.left(speed);
        }
    }

    public void moveRight(int speed) {
        model.setDirection(ACTION.RIGHT);

        // verificar se o modelo se pode mover sem colidir
        Hitbox dummy = model.getHitbox().right(speed);

        if (canMove(dummy)){
            model.right(speed);
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

    @Override
    public abstract void update(GUI gui);
}
