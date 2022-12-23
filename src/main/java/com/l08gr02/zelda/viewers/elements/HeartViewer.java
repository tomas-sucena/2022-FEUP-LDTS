package com.l08gr02.zelda.viewers.elements;

import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.tiles.Heart;
import com.l08gr02.zelda.presenters.GameplayPresenter;

public class HeartViewer extends SpriteViewer<Heart> {
    private int heartcount = 0;

    public HeartViewer() {
        super(new Sprite(16,16,"gfx", "objects"));
        sprite.setPixels(4,8);
    }

    @Override
    public void draw(GUI gui, Heart heart){
        super.draw(gui, heart);
    }

    @Override
    public void drawt(GUI gui, Heart model) {
        super.drawt(gui, model);
    } //For testing purposes only

    @Override
    public void setSprite(GameplayPresenter.ACTION action) {

    }

    public void setHeartSprite(){
        sprite.setPixels(heartcount+4,8);
    }

    public void incrementHeartCount(){
        heartcount++;
        if(heartcount == 4){
            heartcount = 0;
        }
        setHeartSprite();
    }
}
