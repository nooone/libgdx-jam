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
public class ToggleRadarButton extends TextButton {

    private Spaceship spaceship;

    public ToggleRadarButton(Skin skin, final Spaceship spaceship) {
        super("Radar: Off", skin);
        this.spaceship = spaceship;

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SpaceshipConfiguration spaceshipConfiguration = spaceship.getSpaceshipConfiguration();
                spaceshipConfiguration.setRadarEnabled(!spaceshipConfiguration.isRadarEnabled());
                setText("Radar: " + (spaceshipConfiguration.isRadarEnabled() ? "On" : "Off"));
            }
        });
    }
}
