package com.pixelscientists.gdx.jam.ui.hud;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.pixelscientists.gdx.jam.machinery.container.Battery;
import com.pixelscientists.gdx.jam.machinery.container.FuelTank;
import com.pixelscientists.gdx.jam.machinery.ship.Hull;
import com.pixelscientists.gdx.jam.machinery.ship.Shield;

/**
 * @author Daniel Holderbaum
 */
public class HUD extends Table {

    public HUD(Skin skin) {
        super(skin);
        setFillParent(true);

        ShipStatusWindow shipStatusWindow = new ShipStatusWindow(skin);
        add(shipStatusWindow).top().left();
    }
}
