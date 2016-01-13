package com.pixelscientists.gdx.jam.ui.hud.upgrade;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.pixelscientists.gdx.jam.spaceship.Spaceship;

/**
 * @author Daniel Holderbaum
 */
public class UpgradesInformationWindow extends Window {
    public UpgradesInformationWindow(Skin skin) {
        super("Upgrades", skin);

        Spaceship spaceship = new Spaceship();

    }
}
