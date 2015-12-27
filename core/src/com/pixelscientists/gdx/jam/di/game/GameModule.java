package com.pixelscientists.gdx.jam.di.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dagger.Module;
import dagger.Provides;

/**
 * @author Daniel Holderbaum
 */
@Module
public class GameModule {

    private AssetManager assetManager;
    private SpriteBatch spriteBatch;

    public GameModule() {
        assetManager = new AssetManager();
        Texture.setAssetManager(assetManager);
        spriteBatch = new SpriteBatch();
    }

    @Provides
    public AssetManager provideAssetManager() {
        return assetManager;
    }

    @Provides
    public SpriteBatch proviteSpriteBatch() {
        return spriteBatch;
    }

}
