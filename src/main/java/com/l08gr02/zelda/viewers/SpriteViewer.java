package com.l08gr02.zelda.viewers;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public interface SpriteViewer<T> extends Viewer<T> {
    void setSprite(ACTION action);
}
