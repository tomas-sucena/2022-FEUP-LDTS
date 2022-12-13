package com.l08gr02.zelda.presenters.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.elements.Monster;
import com.l08gr02.zelda.presenters.GameplayPresenter;
import com.l08gr02.zelda.presenters.Presenter;
import com.l08gr02.zelda.viewers.Viewer;
import com.l08gr02.zelda.viewers.elements.LinkViewer;
import com.l08gr02.zelda.viewers.elements.MonsterViewer;

import java.util.List;
import java.util.Random;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public class MonsterPresenter {
    private Monster model;
    protected MonsterViewer viewer;
    //private List<MonsterPresenter> monsterPresenters;
    private int actionLockCounter =0;
    private int genMove=2;
    private ACTION action=ACTION.LEFT;
    // constructor
    public MonsterPresenter(Monster model, MonsterViewer viewer){
        this.model=model;
        this.viewer=viewer;
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

    public void update(TextGraphics graphics) {
        viewer.draw(graphics, model);
        actionLockCounter++;
        if(actionLockCounter>60) {
            Random rnd = new Random();
            genMove = rnd.nextInt(4);
            actionLockCounter=0;
        }
        switch(genMove){
                case 0 -> {moveUp(); action=ACTION.UP;}
                case 1 -> {moveDown(); action=ACTION.DOWN;}
                case 2 -> {moveLeft(); action=ACTION.LEFT;}
                case 3 -> {moveRight(); action=ACTION.RIGHT;}
        }
        viewer.setSprite(action);
        viewer.draw(graphics, model);
    }
}
