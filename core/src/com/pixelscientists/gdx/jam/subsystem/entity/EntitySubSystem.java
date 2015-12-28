package com.pixelscientists.gdx.jam.subsystem.entity;

import com.pixelscientists.gdx.jam.entity.Entity;
import com.pixelscientists.gdx.jam.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noone on 27.12.2015.
 */
public class EntitySubSystem {

    public Player player;

    public List<Entity> entities;

    public EntitySubSystem() {
        entities = new ArrayList<Entity>();
    }

    public void update(float deltaTime) {
        for (Entity entity : entities) {
            entity.update(deltaTime);
        }
    }

    public void render() {
        for (Entity entity : entities) {
            entity.render();
        }
    }

}
