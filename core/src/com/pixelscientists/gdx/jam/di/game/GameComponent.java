package com.pixelscientists.gdx.jam.di.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pixelscientists.gdx.jam.di.screen.ScreenComponent;
import com.pixelscientists.gdx.jam.di.screen.ScreenModule;
import dagger.Component;

import javax.inject.Singleton;

/**
 * @author Daniel Holderbaum
 */
@Singleton
@Component(modules = {GameModule.class})
public interface GameComponent {

    ScreenComponent plus(ScreenModule screenModule);

    SpriteBatch spriteBatch();

    AssetManager assetManager();

}
