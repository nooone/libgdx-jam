package com.pixelscientists.gdx.jam.di.application;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dagger.Module;
import dagger.Provides;

/**
 * @author Daniel Holderbaum
 */
@Module
public class ApplicationModule {

    private AssetManager assetManager;
    private SpriteBatch spriteBatch;
    private Game game;

    public ApplicationModule(Game game) {
        this.game = game;
        assetManager = new AssetManager();
        Texture.setAssetManager(assetManager);
        spriteBatch = new SpriteBatch();
    }

    @Provides
    public AssetManager provideAssetManager() {
        return assetManager;
    }

    @Provides
    public SpriteBatch provideSpriteBatch() {
        return spriteBatch;
    }

    @Provides
    public Game provideGame() {
        return game;
    }

}
