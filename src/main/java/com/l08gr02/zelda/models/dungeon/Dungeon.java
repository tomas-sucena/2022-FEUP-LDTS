package com.l08gr02.zelda.models.dungeon;

import com.l08gr02.zelda.models.elements.Element;
import com.l08gr02.zelda.models.elements.Link;
import com.l08gr02.zelda.models.elements.Monster;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    private List<String> map;
    private Link link;
    private List<Monster> monsters;
    private List<Element> tiles;

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

    public List<Element> getTiles(){
        return tiles;
    }

    public void createMap(BufferedReader reader) throws IOException {
        map = new ArrayList<>();

        for (String line; (line = reader.readLine()) != null;){
            map.add(line);
        }
    }

    public void readMap(){
        monsters = new ArrayList<>();
        tiles = new ArrayList<>();

        for (int y = 0; y < map.size(); y++){
            String line = map.get(y);

            for (int x = 0; x < line.length(); x++)
                readChar(line, x, y);
        }
    }

    public void readChar(String line, int x, int y){
        char c = line.charAt(x);

        switch (c) {
            case 'L' -> {link = new Link(x, y);}

            //case 'M' -> {monsters.add(new Monster(x, y));}

            //default -> {tiles.add(new Tile(x, y, c));}
        }
    }

}
