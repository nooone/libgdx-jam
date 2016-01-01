package com.pixelscientists.gdx.jam.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pixelscientists.gdx.commons.graphics.g2d.parallax.ParallaxBackground;
import com.pixelscientists.gdx.commons.graphics.g2d.parallax.ParallaxCamera;
import com.pixelscientists.gdx.commons.graphics.g2d.parallax.ParallaxLayer;
import com.pixelscientists.gdx.jam.di.DI;
import com.pixelscientists.gdx.jam.entity.Asteroid;
import com.pixelscientists.gdx.jam.entity.BlackHole;
import com.pixelscientists.gdx.jam.entity.Mine;
import com.pixelscientists.gdx.jam.entity.Player;
import com.pixelscientists.gdx.jam.entity.enemy.Enemy;
import com.pixelscientists.gdx.jam.subsystem.OverlaySubsystem;
import com.pixelscientists.gdx.jam.subsystem.entity.EntitySubSystem;
import com.pixelscientists.gdx.jam.subsystem.hud.UiSubSystem;
import com.pixelscientists.gdx.jam.subsystem.physics.PhysicsSubSystem;

import javax.inject.Inject;

/**
 * Created by noone on 27.12.2015.
 */
public class GameScreen implements Screen {

    @Inject
    protected PhysicsSubSystem physicsSubSystem;
    @Inject
    protected UiSubSystem uiSubSystem;
    @Inject
    protected EntitySubSystem entitySubSystem;
    @Inject
    protected OverlaySubsystem overlaySubsystem;
    @Inject
    protected Viewport gameViewport;
    @Inject
    protected AssetManager assetManager;
    @Inject
    protected SpriteBatch spriteBatch;

    private Box2DDebugRenderer debugRenderer;

    private ParallaxBackground parallaxBackground;

    @Override
    public void show() {
        DI.newGame();
        DI.getGameComponent().inject(this);
        entitySubSystem.player = new Player();

        Asteroid asteroid1 = new Asteroid(MathUtils.random(0.3f, 2f));
        asteroid1.body.setTransform(new Vector2(3, 3), asteroid1.body.getAngle());

        Asteroid asteroid2 = new Asteroid(MathUtils.random(0.3f, 2f));
        asteroid2.body.setTransform(new Vector2(-3, -3), asteroid2.body.getAngle());

        Asteroid asteroid3 = new Asteroid(MathUtils.random(0.3f, 3f));
        asteroid3.body.setTransform(new Vector2(-3, 3), asteroid3.body.getAngle());

        Asteroid asteroid4 = new Asteroid(MathUtils.random(0.3f, 3f));
        asteroid4.body.setTransform(new Vector2(3, -3), asteroid4.body.getAngle());

        Enemy enemy = new Enemy();

        Mine mine = new Mine();
        mine.body.setTransform(new Vector2(5, 0), mine.body.getAngle());

        BlackHole blackHole = new BlackHole(new Vector2(5, 0));
        blackHole.body.setTransform(new Vector2(0, 5), blackHole.body.getAngle());

        debugRenderer = new Box2DDebugRenderer(true, true, false, true, true, true);

//        parallaxBackground = new ParallaxBackground(new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        parallaxBackground = new ParallaxBackground(new ParallaxCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        ParallaxLayer layer = new ParallaxLayer(new TextureRegion(new Texture("textures/backgrounds/1.jpg")), new Vector2(1f, 1f), new Vector2(0f, 0f), new Vector2(0f, 0f));
        parallaxBackground.layers.add(layer);

        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(uiSubSystem.stage);
        inputMultiplexer.addProcessor(overlaySubsystem.stage);
        inputMultiplexer.addProcessor(new PlayerInputProcessor());
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        physicsSubSystem.update(delta);

        gameViewport.getCamera().position.set(entitySubSystem.player.body.getPosition(), 0);
        gameViewport.getCamera().update(true);

        parallaxBackground.render(spriteBatch, entitySubSystem.player.body.getPosition());

        entitySubSystem.update(delta);

        overlaySubsystem.stage.act(delta);
        uiSubSystem.stage.act(delta);

        spriteBatch.setProjectionMatrix(gameViewport.getCamera().combined);
        spriteBatch.begin();
        entitySubSystem.render();
        spriteBatch.end();

        debugRenderer.render(physicsSubSystem.world, gameViewport.getCamera().combined);

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void resize(int width, int height) {
        uiSubSystem.stage.getViewport().update(width, height, true);
        gameViewport.update(width, height);

        parallaxBackground = new ParallaxBackground(new ParallaxCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        ParallaxLayer layer = new ParallaxLayer(new TextureRegion(new Texture("textures/backgrounds/1.jpg")), new Vector2(1f, 1f), new Vector2(0f, 0f), new Vector2(0f, 0f));
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
        uiSubSystem.dispose();
    }
}
