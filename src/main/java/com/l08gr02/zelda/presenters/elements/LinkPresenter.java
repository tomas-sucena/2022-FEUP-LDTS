package com.l08gr02.zelda.presenters.elements;

import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.elements.moving.Link;
import com.l08gr02.zelda.models.sound.SoundEffect;
import com.l08gr02.zelda.viewers.elements.LinkViewer;

import java.util.List;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public class LinkPresenter extends FighterPresenter<Link> {
    private List<ACTION> actions;
    private SoundEffect walkSFX, swordSFX, lowHP;

    // constructor
    public LinkPresenter(Link model, LinkViewer viewer){
        super(model, viewer);

        walkSFX = new SoundEffect("walk_grass");
        swordSFX = new SoundEffect("sword");
        healingSFX = new SoundEffect("heart");
        damagedSFX = new SoundEffect("link hurt");
        lowHP = new SoundEffect("low hp");
    }

    // methods
    public void setActions(List<ACTION> actions) {
        this.actions = actions;
    }

    public boolean isAttacking(){
        return ((LinkViewer) viewer).isAttacking();
    }

    public void walk(){
        model.walk();
    }

    public void sprint(){
        model.sprint();
    }

    public void playSoundEffects(List<ACTION> actions){
        if (actions.contains(ACTION.ATTACK)){
            swordSFX.play();
        }
        else if (actions.contains(ACTION.UP) || actions.contains(ACTION.DOWN) ||
                 actions.contains(ACTION.LEFT) || actions.contains(ACTION.RIGHT)){
            walkSFX.play();
        }
    }

    @Override
    public void takeDamage(float heartsLost, ACTION attackDirection){
        super.takeDamage(heartsLost, attackDirection);

        if (model.getHearts() <= 1){
            lowHP.play();
        }
    }

    @Override
    public void update(GUI gui) {
        super.decreaseImmunity();

        walk();

        // verificar se o Link está a atacar
        LinkViewer linkViewer = (LinkViewer) viewer;

        if (linkViewer.isAttacking()){
            linkViewer.setSprite(ACTION.ATTACK);
            viewer.draw(gui, model);
            attack();

            return;
        }

        for (ACTION action : actions){
            linkViewer.setSprite(action);

            switch (action){
                case UP -> moveUp(model.getSpeed());

                case DOWN -> moveDown(model.getSpeed());

                case LEFT -> moveLeft(model.getSpeed());

                case RIGHT -> moveRight(model.getSpeed());

                case SPRINT -> sprint();

                case ATTACK -> attack();
            }
        }

        viewer.draw(gui, model);

        playSoundEffects(actions);
    }

}
