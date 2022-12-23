package com.l08gr02.zelda.viewers.elements.tiles;

import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.tiles.Bush;
import com.l08gr02.zelda.viewers.elements.SpriteViewer;

public class BushViewer extends SpriteViewer<Bush> {
    public BushViewer() {
        super(new Sprite(16, 16, "dungeon", "Overworld"));
        sprite.setPixels(2, 14);
    }

    @Override
    public void draw(GUI gui, Bush bush){
        switch (bush.getC()){
            case 'B' -> sprite.setPixels(2, 14);
            case '1' -> sprite.setPixels(1,13);
            case '2' -> sprite.setPixels(2,13);
            case '3' -> sprite.setPixels(3,13);
            case '4' -> sprite.setPixels(1,14);
            case '5' -> sprite.setPixels(1,15);
            case '6' -> sprite.setPixels(3,15);
            case '7' -> sprite.setPixels(0,14);
        }

        super.draw(gui, bush);
    }
}
