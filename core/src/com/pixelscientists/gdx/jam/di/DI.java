package com.pixelscientists.gdx.jam.di;

import com.pixelscientists.gdx.jam.di.game.DaggerGameComponent;
import com.pixelscientists.gdx.jam.di.game.GameComponent;
import com.pixelscientists.gdx.jam.di.game.GameModule;
import com.pixelscientists.gdx.jam.di.screen.ScreenComponent;
import com.pixelscientists.gdx.jam.di.screen.ScreenModule;

/**
 * Created by noone on 27.12.2015.
 */
public abstract class DI {

    private static GameComponent gameComponent;
    private static ScreenComponent screenComponent;

    public static void newGame() {
        gameComponent = DaggerGameComponent.builder().gameModule(new GameModule()).build();
    }

    public static void newScreen() {
        screenComponent = gameComponent.plus(new ScreenModule());
    }


    public static GameComponent getGameComponent() {
        return gameComponent;
    }

    public static ScreenComponent getScreenComponent() {
        return screenComponent;
    }
}
