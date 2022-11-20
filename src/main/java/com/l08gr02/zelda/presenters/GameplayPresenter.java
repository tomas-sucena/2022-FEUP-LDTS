package com.l08gr02.zelda.presenters;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.Gameplay;
import com.l08gr02.zelda.viewers.GameplayViewer;
import com.l08gr02.zelda.viewers.Viewer;

public class GameplayPresenter {
    private Gameplay model;
    private GameplayViewer viewer;

    // constructor
    public GameplayPresenter(Gameplay model, GameplayViewer viewer) {
        this.model = model;
        this.viewer = viewer;
    }

}
