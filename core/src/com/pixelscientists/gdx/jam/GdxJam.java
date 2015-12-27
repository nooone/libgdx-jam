package com.pixelscientists.gdx.jam;

import com.badlogic.gdx.Game;
import com.pixelscientists.gdx.jam.di.DI;
import com.pixelscientists.gdx.jam.screen.GameScreen;

public class GdxJam extends Game {

    @Override
    public void create() {
        DI.newGame();
        setScreen(new GameScreen());
    }

    @Override
    public void render() {
    }
}
