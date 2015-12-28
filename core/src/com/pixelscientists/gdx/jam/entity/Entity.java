package com.pixelscientists.gdx.jam.entity;

import com.badlogic.gdx.utils.Disposable;
import com.pixelscientists.gdx.jam.di.DI;

/**
 * @author Daniel Holderbaum
 */
public abstract class Entity implements Disposable {

    public Entity() {
        DI.getGameComponent().entitySubSystem().entities.add(this);
    }

    public abstract void render();

    public abstract void update(float deltaTime);

    @Override
    public void dispose() {
        DI.getGameComponent().entitySubSystem().entities.remove(this);
    }
}
