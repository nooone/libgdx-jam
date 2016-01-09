package com.pixelscientists.gdx.jam.ui.hud.configuration;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pixelscientists.gdx.jam.machinery.Spaceship;
import com.pixelscientists.gdx.jam.machinery.SpaceshipConfiguration;

/**
 * @author Daniel Holderbaum
 */
public class ToggleBurnOxygenButton extends TextButton {

    private Spaceship spaceship;

    public ToggleBurnOxygenButton(Skin skin, final Spaceship spaceship) {
        super("Generator (Oxygen): Off", skin);
        this.spaceship = spaceship;

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SpaceshipConfiguration spaceshipConfiguration = spaceship.getSpaceshipConfiguration();
                spaceshipConfiguration.setBurnOxygenEnabled(!spaceshipConfiguration.isBurnOxygenEnabled());
                setText("Generator (Oxygen): " + (spaceshipConfiguration.isBurnOxygenEnabled() ? "On" : "Off"));
            }
        });
    }
}
