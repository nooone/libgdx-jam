package com.pixelscientists.gdx.jam.ui.hud.configuration;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pixelscientists.gdx.jam.spaceship.Spaceship;
import com.pixelscientists.gdx.jam.spaceship.SpaceshipConfiguration;

/**
 * @author Daniel Holderbaum
 */
public class ToggleRadarButton extends TextButton {

    private Spaceship spaceship;

    public ToggleRadarButton(Skin skin, final Spaceship spaceship) {
        super("Off", skin);
        this.spaceship = spaceship;

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SpaceshipConfiguration spaceshipConfiguration = spaceship.getSpaceshipConfiguration();
                spaceshipConfiguration.setRadarEnabled(!spaceshipConfiguration.isRadarEnabled());
                setText(spaceshipConfiguration.isRadarEnabled() ? "On" : "Off");
            }
        });
    }
}
