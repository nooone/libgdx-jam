package com.pixelscientists.gdx.jam.di.screen;

import com.pixelscientists.gdx.jam.screen.GameScreen;
import com.pixelscientists.gdx.jam.subsystem.physics.PhysicsSubSystem;
import dagger.Subcomponent;

/**
 * @author Daniel Holderbaum
 */
@ScreenScoped
@Subcomponent(modules = {ScreenModule.class})
public interface ScreenComponent {

    void inject(GameScreen gameScreen);

}
