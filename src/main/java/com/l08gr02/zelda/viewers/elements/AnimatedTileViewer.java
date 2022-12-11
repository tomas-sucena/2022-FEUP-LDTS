package com.l08gr02.zelda.viewers.elements;

import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.tiles.AnimatedTile;
import com.l08gr02.zelda.presenters.GameplayPresenter;
import com.l08gr02.zelda.viewers.SpriteViewer;

public class AnimatedTileViewer extends SpriteViewer<AnimatedTile> {

    private int frameCount = 0;
    private int ygrid = 0;
    private int count = 0;
    public AnimatedTileViewer() {
        super(new Sprite(32,32,"Dungeon", "Overworld"));
        sprite.setPixels(8,0);
    }

    @Override
    public void setSprite(GameplayPresenter.ACTION action) {

    }
    public void setSprite(){
        frameCount++;
        count++;
        if(frameCount == 3){
            ygrid++;
            count = 0;
            sprite.setPixels(8,ygrid);
        }
        else if (frameCount == 6){
            ygrid--;
            count = 0;
            sprite.setPixels(8,ygrid);
            frameCount = 0;
        }
        sprite.setPixels(8+count,ygrid);
    }

}
