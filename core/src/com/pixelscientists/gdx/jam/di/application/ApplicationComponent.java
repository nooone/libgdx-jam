package com.pixelscientists.gdx.jam.di.application;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pixelscientists.gdx.jam.di.game.GameComponent;
import com.pixelscientists.gdx.jam.di.game.GameModule;
import com.pixelscientists.gdx.jam.screen.GameScreen;
import com.pixelscientists.gdx.jam.screen.LoadingScreen;
import dagger.Component;

import javax.inject.Singleton;

/**
 * @author Daniel Holderbaum
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    GameComponent plus(GameModule gameModule);

    SpriteBatch spriteBatch();
    AssetManager assetManager();
    Game game();

    void inject(LoadingScreen loadingScreen);

}
