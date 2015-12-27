package com.pixelscientists.gdx.jam.di.screen;

import com.pixelscientists.gdx.jam.subsystem.physics.PhysicsSubSystem;
import dagger.Module;
import dagger.Provides;

/**
 * @author Daniel Holderbaum
 */
@Module
public class ScreenModule {

    private PhysicsSubSystem physicsSubSystem;

    public ScreenModule() {
        physicsSubSystem = new PhysicsSubSystem();
    }

    @Provides
    public PhysicsSubSystem providePhysicsSubSystem() {
        return physicsSubSystem;
    }

}
