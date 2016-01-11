package com.pixelscientists.gdx.jam.ui.hud.status;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.pixelscientists.gdx.jam.machinery.Spaceship;
import com.pixelscientists.gdx.jam.machinery.container.Battery;
import com.pixelscientists.gdx.jam.machinery.container.FuelTank;
import com.pixelscientists.gdx.jam.machinery.ship.Hull;
import com.pixelscientists.gdx.jam.machinery.ship.Shield;

/**
 * @author Daniel Holderbaum
 */
public class ShipStatusWindow extends Window {

    public ShipStatusWindow(Spaceship spaceship, Skin skin) {
        super("Ship", skin);
        columnDefaults(0).left();

        add(new Label("Hull ", skin));
        HullProgessBar hullProgessBar = new HullProgessBar(spaceship.getHull(), skin);
        add(hullProgessBar);
        row();
        add(new Label("Shield ", skin));
        ShieldProgessBar shieldProgessBar = new ShieldProgessBar(spaceship.getShield(), skin);
        add(shieldProgessBar);
        row();
        add(new Label("Battery ", skin));
        BatteryProgessBar batteryProgessBar = new BatteryProgessBar(spaceship.getBattery(), skin);
        add(batteryProgessBar);
        row();
        add(new Label("Fuel ", skin));
        FuelProgressBar fuelProgressBar = new FuelProgressBar(spaceship.getFuelTank(), skin);
        add(fuelProgressBar);
        row();
    }
}
