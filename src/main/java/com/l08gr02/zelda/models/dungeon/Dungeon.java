package com.l08gr02.zelda.models.dungeon;

import com.l08gr02.zelda.models.elements.moving.Link;
import com.l08gr02.zelda.models.elements.moving.Monster;
import com.l08gr02.zelda.models.elements.tiles.AnimatedTile;
import com.l08gr02.zelda.models.elements.tiles.Heart;
import com.l08gr02.zelda.models.elements.tiles.StaticTile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    private int ignore = 0;
    private List<String> map;
    private Link link;
    private List<Monster> monsters;
    private List<StaticTile> stiles;

    private List<AnimatedTile> atiles;

    private List<Heart> hearts;

    // constructor
    public Dungeon() throws IOException {
        URL resource = Dungeon.class.getResource("/models/Dungeon/map.txt");
        BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()));

        createMap(reader);
        readMap();
    }

    // methods
    public Link getLink() {
        return link;
    }

    public List<AnimatedTile> getAtiles(){return atiles;}
    public List<StaticTile> getStiles(){
        return stiles;
    }

    public void createMap(BufferedReader reader) throws IOException {
        map = new ArrayList<>();

        for (String line; (line = reader.readLine()) != null;){
            map.add(line);
        }
    }

    public void readMap(){
        monsters = new ArrayList<>();
        stiles = new ArrayList<>();
        atiles = new ArrayList<>();
        hearts = new ArrayList<>();

        for (int y = 0; y < map.size(); y++){
            String line = map.get(y);

            for (int x = 0; x < line.length(); x++)
                readChar(line, x, y);
        }
    }

    public void readChar(String line, int x, int y){
        char c = line.charAt(x);

        x *= 16; y *= 16;

        switch (c) {
            case 'L' -> {
                link = new Link(x, y);
                stiles.add(new StaticTile(x, y, c));
            }

            //case 'M' -> {monsters.add(new Monster(x, y));}

            case 'H' -> {hearts.add(new Heart(x, y));}

            case 'W' -> {atiles.add(new AnimatedTile(x, y, c));}

            default -> {stiles.add(new StaticTile(x, y, c));}
        }
    }

    public List<Heart> getHearts() {
        return hearts;
    }
}
