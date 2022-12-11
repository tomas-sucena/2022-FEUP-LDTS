package com.l08gr02.zelda.viewers.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.tiles.Heart;
import com.l08gr02.zelda.presenters.GameplayPresenter;
import com.l08gr02.zelda.viewers.SpriteViewer;

public class HeartViewer extends SpriteViewer<Heart> {
    private int heartcount = 0;
    public HeartViewer() {
        super(new Sprite(16,16,"gfx", "objects"));
        sprite.setPixels(4,8);
    }

    @Override
    public void draw(TextGraphics graphics, Heart heart){
        super.draw(graphics, heart);
    }

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
