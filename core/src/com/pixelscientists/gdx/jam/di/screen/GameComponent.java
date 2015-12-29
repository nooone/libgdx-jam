package com.pixelscientists.gdx.jam.di.screen;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.pixelscientists.gdx.jam.screen.GameScreen;
import com.pixelscientists.gdx.jam.subsystem.OverlaySubsystem;
import com.pixelscientists.gdx.jam.subsystem.entity.EntitySubSystem;
import com.pixelscientists.gdx.jam.subsystem.hud.UiSubSystem;
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
    UiSubSystem uiSubSystem();
    OverlaySubsystem overlaySubSystem();
    Viewport gameViewport();

    void inject(GameScreen gameScreen);

}
