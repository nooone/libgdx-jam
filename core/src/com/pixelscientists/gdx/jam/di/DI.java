package com.pixelscientists.gdx.jam.di;

import com.pixelscientists.gdx.jam.di.game.DaggerApplicationComponent;
import com.pixelscientists.gdx.jam.di.game.ApplicationComponent;
import com.pixelscientists.gdx.jam.di.game.ApplicationModule;
import com.pixelscientists.gdx.jam.di.screen.GameComponent;
import com.pixelscientists.gdx.jam.di.screen.GameModule;

/**
 * Created by noone on 27.12.2015.
 */
public abstract class DI {

    private static ApplicationComponent applicationComponent;
    private static GameComponent gameComponent;

    public static void newApplication() {
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule()).build();
    }

    public static void newGame() {
        gameComponent = applicationComponent.plus(new GameModule());
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static GameComponent getGameComponent() {
        return gameComponent;
    }
}
