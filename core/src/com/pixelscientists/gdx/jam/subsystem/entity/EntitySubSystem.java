package com.pixelscientists.gdx.jam.subsystem.entity;

import com.badlogic.gdx.utils.Array;
import com.pixelscientists.gdx.jam.entity.Entity;
import com.pixelscientists.gdx.jam.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noone on 27.12.2015.
 */
public class EntitySubSystem {

    public Player player;

    private Array<Entity> entitiesToAdd;
    private Array<Entity> entitiesToRemove;
    private Array<Entity> entities;

    public EntitySubSystem() {
        entitiesToAdd = new Array<Entity>();
        entitiesToRemove = new Array<Entity>();
        entities = new Array<Entity>();
    }

    public void addEntity(Entity entity) {
        entitiesToAdd.add(entity);
    }

    public void removeEntity(Entity entity) {
        entitiesToRemove.add(entity);
    }

    public void update(float deltaTime) {
        for (Entity entity : entitiesToAdd) {
            entities.add(entity);
        }
        entitiesToAdd.clear();

        for (Entity entity : entitiesToRemove) {
            entities.removeValue(entity, true);
        }
        entitiesToRemove.clear();

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
