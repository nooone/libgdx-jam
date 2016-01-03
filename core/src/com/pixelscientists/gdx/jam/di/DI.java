package com.pixelscientists.gdx.jam.di;

import com.badlogic.gdx.Game;
import com.pixelscientists.gdx.jam.di.application.DaggerApplicationComponent;
import com.pixelscientists.gdx.jam.di.application.ApplicationComponent;
import com.pixelscientists.gdx.jam.di.application.ApplicationModule;
import com.pixelscientists.gdx.jam.di.game.GameComponent;
import com.pixelscientists.gdx.jam.di.game.GameModule;

/**
 * @author Daniel Holderbaum
 */
public abstract class DI {

    private static ApplicationComponent applicationComponent;
    private static GameComponent gameComponent;

    public static void newApplication(Game game) {
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(game)).build();
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
