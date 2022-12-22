package com.l08gr02.zelda.presenters.elements.monsters;

import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.models.elements.moving.monsters.Log;
import com.l08gr02.zelda.models.elements.moving.monsters.Monster;
import com.l08gr02.zelda.models.elements.moving.monsters.Weirdo;
import com.l08gr02.zelda.viewers.elements.monsters.LogViewer;
import com.l08gr02.zelda.viewers.elements.monsters.WeirdoViewer;

import java.util.ArrayList;
import java.util.List;

public class MonsterPresenterFactory {
    // method
    public List<MonsterPresenter> createPresenters(Dungeon dungeon){
        List<MonsterPresenter> monsterPresenters = new ArrayList<>();

        for (Monster monster : dungeon.getMonsters()){
            if (monster instanceof Log){
                LogPresenter logPresenter = new LogPresenter((Log) monster, new LogViewer());
                //logPresenter.setTarget(dungeon.getLink());

                monsterPresenters.add(logPresenter);
                continue;
            }

            monsterPresenters.add(new WeirdoPresenter((Weirdo) monster, new WeirdoViewer()));
        }

        return monsterPresenters;
    }
}
