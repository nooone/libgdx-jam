package com.pixelscientists.gdx.jam.di.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.pixelscientists.gdx.jam.subsystem.entity.EntitySubSystem;
import com.pixelscientists.gdx.jam.subsystem.hud.HudSubSystem;
import com.pixelscientists.gdx.jam.subsystem.physics.PhysicsSubSystem;
import dagger.Module;
import dagger.Provides;

/**
 * @author Daniel Holderbaum
 */
@Module
public class GameModule {

    private PhysicsSubSystem physicsSubSystem;
    private EntitySubSystem entitySubSystem;
    private HudSubSystem hudSubSystem;

    public GameModule() {
        physicsSubSystem = new PhysicsSubSystem();
        entitySubSystem = new EntitySubSystem();
        hudSubSystem = new HudSubSystem();
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
    public HudSubSystem provideHudSubSystem() {
        return hudSubSystem;
    }

}
