package com.l08gr02.zelda.presenters.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.elements.Link;
import com.l08gr02.zelda.presenters.GameplayPresenter;
import com.l08gr02.zelda.presenters.Presenter;
import com.l08gr02.zelda.viewers.elements.LinkViewer;

public class LinkPresenter extends Presenter<Link> {
    // constructor
    public LinkPresenter(Link model, LinkViewer viewer){
        super(model, viewer);
    }

    // methods
    public void moveUp(){
        model.up(1);
    }

    public void moveDown(){
        model.down(1);
    }

    public void moveLeft(){
        model.left(1);
    }

    public void moveRight(){
        model.right(1);
    }

    @Override
    public void update(TextGraphics graphics, GameplayPresenter.ACTION action){
        LinkViewer viewer_v2 = (LinkViewer) viewer;
        viewer_v2.setSprite(action);

        switch (action){
            case UP -> {moveUp();}

            case DOWN -> {moveDown();}

            case LEFT -> {moveLeft();}

            case RIGHT -> {moveRight();}
        }

        viewer.draw(graphics, model);
    }

}
