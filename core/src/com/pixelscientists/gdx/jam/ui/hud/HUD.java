package com.pixelscientists.gdx.jam.ui.hud;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.pixelscientists.gdx.jam.spaceship.Spaceship;
import com.pixelscientists.gdx.jam.ui.hud.configuration.ShipConfigurationWindow;
import com.pixelscientists.gdx.jam.ui.hud.status.ShipStatusWindow;

/**
 * @author Daniel Holderbaum
 */
public class HUD extends Table {

    public HUD(Skin skin) {
        super(skin);
        setFillParent(true);

        Spaceship spaceship = new Spaceship();

        ShipStatusWindow shipStatusWindow = new ShipStatusWindow(spaceship, skin);
        add(shipStatusWindow).top().left();
        ShipConfigurationWindow shipConfigurationWindow = new ShipConfigurationWindow(spaceship, skin);
        add(shipConfigurationWindow).top().right();
    }
}
