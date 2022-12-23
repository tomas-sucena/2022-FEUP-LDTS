package com.l08gr02.zelda.Presenter;

import com.l08gr02.zelda.models.elements.moving.Link;
import com.l08gr02.zelda.presenters.GameplayPresenter;
import com.l08gr02.zelda.presenters.elements.LinkPresenter;
import com.l08gr02.zelda.viewers.elements.moving.LinkViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkPresenterTest {
    private Link link;
    private LinkViewer linkViewer;
    private LinkPresenter linkPresenter;

    @BeforeEach
    void setup(){
        link = new Link(10,10);
        linkViewer = new LinkViewer();
        linkPresenter = new LinkPresenter(link, linkViewer);

    }
    @Test
    void bumpUP(){
        linkPresenter.bump(link.getDirection());
        assertEquals(GameplayPresenter.ACTION.UP, link.getDirection());
        assertEquals(2.25, link.getHearts());
        assertEquals(10, link.getPosition().getX());
        assertEquals(10-16,link.getPosition().getY());
    }

    @Test
    void bumpDOWN(){
        link.setDirection(GameplayPresenter.ACTION.UP);
        linkPresenter.bump(link.getDirection());
        assertEquals(GameplayPresenter.ACTION.DOWN, link.getDirection());
        assertEquals(2.25, link.getHearts());
        assertEquals(10, link.getPosition().getX());
        assertEquals(10+16,link.getPosition().getY());
    }

    @Test
    void bumpLEFT(){
        link.setDirection(GameplayPresenter.ACTION.RIGHT);
        linkPresenter.bump(link.getDirection());
        assertEquals(GameplayPresenter.ACTION.LEFT, link.getDirection());
        assertEquals(2.25, link.getHearts());
        assertEquals(10-16, link.getPosition().getX());
        assertEquals(10,link.getPosition().getY());
    }

    @Test
    void bumpRIGHT(){
        link.setDirection(GameplayPresenter.ACTION.LEFT);
        linkPresenter.bump(link.getDirection());
        assertEquals(GameplayPresenter.ACTION.RIGHT, link.getDirection());
        assertEquals(2.25, link.getHearts());
        assertEquals(10+16, link.getPosition().getX());
        assertEquals(10,link.getPosition().getY());
    }
}
