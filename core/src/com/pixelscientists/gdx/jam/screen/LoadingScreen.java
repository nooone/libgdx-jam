package com.pixelscientists.gdx.jam.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.pixelscientists.gdx.jam.di.DI;

import javax.inject.Inject;

/**
 * @author Daniel Holderbaum
 */
public class LoadingScreen implements Screen {

    @Inject
    protected AssetManager assetManager;

    @Inject
    protected Game game;

    @Override
    public void show() {
        DI.getApplicationComponent().inject(this);
        assetManager.load("skins/uiskin.json", Skin.class);
    }

    @Override
    public void render(float delta) {
        if (assetManager.update()) {
            DI.getApplicationComponent().game().setScreen(new GameScreen());
        }
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
    }

    @Override
    public void dispose() {
    }
}
