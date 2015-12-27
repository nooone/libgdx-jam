package com.pixelscientists.gdx.jam.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.pixelscientists.gdx.jam.di.DI;
import com.pixelscientists.gdx.jam.subsystem.physics.PhysicsSubSystem;

import javax.inject.Inject;

/**
 * Created by noone on 27.12.2015.
 */
public class GameScreen implements Screen {

    @Inject
    protected PhysicsSubSystem physicsSubSystem;

    @Inject
    protected AssetManager assetManager;

    @Override
    public void show() {
        DI.newScreen();
        DI.getScreenComponent().inject(this);
    }

    @Override
    public void render(float delta) {
        physicsSubSystem.update(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        physicsSubSystem.dispose();
    }
}
