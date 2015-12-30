package com.pixelscientists.gdx.jam.di.game;

import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pixelscientists.gdx.jam.subsystem.OverlaySubsystem;
import com.pixelscientists.gdx.jam.subsystem.entity.EntitySubSystem;
import com.pixelscientists.gdx.jam.subsystem.hud.UiSubSystem;
import com.pixelscientists.gdx.jam.subsystem.physics.PhysicsSubSystem;
import dagger.Module;
import dagger.Provides;

/**
 * @author Daniel Holderbaum
 */
@Module
public class GameModule {

    private Viewport gameViewport;

    private PhysicsSubSystem physicsSubSystem;
    private EntitySubSystem entitySubSystem;
    private OverlaySubsystem overlaySubsystem;
    private UiSubSystem uiSubSystem;

    public GameModule() {
        gameViewport = new ExtendViewport(16, 9, 16, 12);
        physicsSubSystem = new PhysicsSubSystem();
        entitySubSystem = new EntitySubSystem();
        uiSubSystem = new UiSubSystem();
        overlaySubsystem = new OverlaySubsystem(gameViewport);
    }

    @Provides
    public PhysicsSubSystem providePhysicsSubSystem() {
        return physicsSubSystem;
    }

    @Provides
    public EntitySubSystem provideEntitySubSystem() {
        return entitySubSystem;
    }

    @Provides
    public UiSubSystem provideUiSubSystem() {
        return uiSubSystem;
    }

    @Provides
    public OverlaySubsystem provideOverlaySubsystem() {
        return overlaySubsystem;
    }

    @Provides
    public Viewport provideGameViewport() {
        return gameViewport;
    }

}
