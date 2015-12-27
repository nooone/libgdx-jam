package com.pixelscientists.gdx.jam.di.screen;

import com.pixelscientists.gdx.jam.screen.GameScreen;
import com.pixelscientists.gdx.jam.subsystem.entity.EntitySubSystem;
import com.pixelscientists.gdx.jam.subsystem.hud.HudSubSystem;
import com.pixelscientists.gdx.jam.subsystem.physics.PhysicsSubSystem;
import dagger.Subcomponent;

/**
 * @author Daniel Holderbaum
 */
@GameScoped
@Subcomponent(modules = {GameModule.class})
public interface GameComponent {

    PhysicsSubSystem physicsSubSystem();
    EntitySubSystem entitySubSystem();
    HudSubSystem hudSubSystem();

    void inject(GameScreen gameScreen);

}
