package com.l08gr02.zelda.models.dungeon;

import com.l08gr02.zelda.models.elements.Element;
import com.l08gr02.zelda.models.elements.moving.Link;
import com.l08gr02.zelda.models.elements.moving.monsters.Log;
import com.l08gr02.zelda.models.elements.moving.monsters.Monster;
import com.l08gr02.zelda.models.elements.tiles.Bush;
import com.l08gr02.zelda.models.elements.tiles.Grass;
import com.l08gr02.zelda.models.elements.tiles.Heart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    private List<String> map;
    private List<Element> tiles;
    private Link link;
    private List<Monster> monsters;
    private List<Heart> hearts;

    // constructor
    public Dungeon() throws IOException {
        URL resource = Dungeon.class.getResource("/models/dungeon/map.txt");
        assert resource != null;

        BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()));

        createMap(reader);
        readMap();
    }

    // methods
    public List<String> getMap(){
        return map;
    }

    public List<Element> getTiles() {
        return tiles;
    }

    public Link getLink(){
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public List<Monster> getMonsters(){
        return monsters;
    }

    public List<Heart> getHearts(){
        return hearts;
    }

    public void createMap(BufferedReader reader) throws IOException {
        map = new ArrayList<>();

        for (String line; (line = reader.readLine()) != null;){
            map.add(line);
        }
    }

    public void readMap(){
        monsters = new ArrayList<>();
        hearts = new ArrayList<>();
        tiles = new ArrayList<>();

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
                tiles.add(new Grass(x, y));
            }

            case 'M' -> {
                monsters.add(new Log(x, y));
                tiles.add(new Grass(x, y));
            }

            case 'H' -> {
                hearts.add(new Heart(x, y));
                tiles.add(new Grass(x, y));
            }

            case 'B' -> {
                tiles.add(new Grass(x, y));
                tiles.add(new Bush(x, y));
            }

            default -> tiles.add(new Grass(x, y));
        }
    }

}
