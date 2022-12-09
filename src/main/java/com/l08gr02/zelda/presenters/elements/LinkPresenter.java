package com.l08gr02.zelda.presenters.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.elements.Link;
import com.l08gr02.zelda.presenters.Presenter;
import com.l08gr02.zelda.viewers.elements.LinkViewer;

import java.util.List;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public class LinkPresenter extends Presenter<Link> {
    // constructor
    public LinkPresenter(Link model, LinkViewer viewer){
        super(model, viewer);
    }

    // methods
    public void moveUp(){
        model.up(model.getSpeed());
    }

    public void moveDown(){
        model.down(model.getSpeed());
    }

    public void moveLeft(){
        model.left(model.getSpeed());
    }

    public void moveRight(){
        model.right(model.getSpeed());
    }

    public void walk(){
        model.walk();
    }

    public void sprint(){
        model.sprint();
    }

    @Override
    public void update(TextGraphics graphics, List<ACTION> actions){
        walk();

        for (ACTION action : actions){
            ((LinkViewer) viewer).setSprite(action);

            switch (action){
                case UP -> {moveUp();}

                case DOWN -> {moveDown();}

                case LEFT -> {moveLeft();}

                case RIGHT -> {moveRight();}

                case SPRINT -> {sprint();}
            }
        }

        viewer.draw(graphics, model);
    }

}
