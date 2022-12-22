package com.l08gr02.zelda.viewers.elements.tiles;

import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.tiles.Bush;
import com.l08gr02.zelda.viewers.elements.SpriteViewer;

public class BushViewer extends SpriteViewer<Bush> {
    public BushViewer() {
        super(new Sprite(16, 16, "dungeon", "Overworld"));
        sprite.setPixels(2, 14);
    }
}
