package com.l08gr02.zelda.presenters.elements;

import com.l08gr02.zelda.models.elements.Link;
import com.l08gr02.zelda.presenters.Presenter;
import com.l08gr02.zelda.viewers.elements.LinkViewer;

public class LinkPresenter extends Presenter<Link> {
    // constructor
    public LinkPresenter(Link model, LinkViewer viewer){
        super(model, viewer);
    }
}
