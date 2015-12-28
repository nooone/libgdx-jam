package com.pixelscientists.gdx.jam.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pixelscientists.gdx.commons.graphics.g2d.parallax.ParallaxBackground;
import com.pixelscientists.gdx.commons.graphics.g2d.parallax.ParallaxCamera;
import com.pixelscientists.gdx.commons.graphics.g2d.parallax.ParallaxLayer;
import com.pixelscientists.gdx.jam.di.DI;
import com.pixelscientists.gdx.jam.entity.Player;
import com.pixelscientists.gdx.jam.subsystem.entity.EntitySubSystem;
import com.pixelscientists.gdx.jam.subsystem.hud.HudSubSystem;
import com.pixelscientists.gdx.jam.subsystem.physics.PhysicsSubSystem;

import javax.inject.Inject;

/**
 * Created by noone on 27.12.2015.
 */
public class GameScreen implements Screen {

    @Inject
    protected PhysicsSubSystem physicsSubSystem;
    @Inject
    protected HudSubSystem hudSubSystem;
    @Inject
    protected EntitySubSystem entitySubSystem;

    @Inject
    protected AssetManager assetManager;
    @Inject
    protected SpriteBatch spriteBatch;

    private Box2DDebugRenderer debugRenderer;

    private Viewport viewport;

    private ParallaxBackground parallaxBackground;

    @Override
    public void show() {
        DI.newGame();
        DI.getGameComponent().inject(this);
        entitySubSystem.player = new Player();

//        viewport = new FitViewport(16, 9);
        viewport = new ExtendViewport(16, 9, 16, 12);
        debugRenderer = new Box2DDebugRenderer(true, true, false, true, true, true);

//        parallaxBackground = new ParallaxBackground(new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        parallaxBackground = new ParallaxBackground(new ParallaxCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        ParallaxLayer layer = new ParallaxLayer(new TextureRegion(new Texture("fx/1.jpg")), new Vector2(1f, 1f), new Vector2(0f, 0f), new Vector2(0f, 0f));
        parallaxBackground.layers.add(layer);

        Gdx.input.setInputProcessor(new PlayerInputProcessor());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        physicsSubSystem.update(delta);

        viewport.getCamera().position.set(entitySubSystem.player.body.getPosition(), 0);
        viewport.getCamera().update(true);

        parallaxBackground.render(spriteBatch, entitySubSystem.player.body.getPosition());

        entitySubSystem.update(delta);

        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
//        spriteBatch.setTransformMatrix(viewport.getCamera().view);
        spriteBatch.begin();
        entitySubSystem.render();
        spriteBatch.end();

        debugRenderer.render(physicsSubSystem.world, viewport.getCamera().combined);
    }

    @Override
    public void resize(int width, int height) {
        hudSubSystem.stage.getViewport().update(width, height, true);
        viewport.update(width, height);

        parallaxBackground = new ParallaxBackground(new ParallaxCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        ParallaxLayer layer = new ParallaxLayer(new TextureRegion(new Texture("fx/1.jpg")), new Vector2(1f, 1f), new Vector2(0f, 0f), new Vector2(0f, 0f));
        parallaxBackground.layers.add(layer);
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
        hudSubSystem.dispose();
    }
}
