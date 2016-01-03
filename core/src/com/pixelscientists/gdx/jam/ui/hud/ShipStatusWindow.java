package com.pixelscientists.gdx.jam.ui.hud;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.pixelscientists.gdx.jam.machinery.container.Battery;
import com.pixelscientists.gdx.jam.machinery.container.FuelTank;
import com.pixelscientists.gdx.jam.machinery.ship.Hull;
import com.pixelscientists.gdx.jam.machinery.ship.Shield;

/**
 * @author Daniel Holderbaum
 */
public class ShipStatusWindow extends Window {

    public ShipStatusWindow(Skin skin) {
        super("Ship", skin);
        columnDefaults(0).left();

        add(new Label("Hull ", skin));
        HullProgessBar hullProgessBar = new HullProgessBar(new Hull(), skin);
        add(hullProgessBar);
        row();
        add(new Label("Shield ", skin));
        ShieldProgessBar shieldProgessBar = new ShieldProgessBar(new Shield(), skin);
        add(shieldProgessBar);
        row();
        add(new Label("Battery ", skin));
        BatteryProgessBar batteryProgessBar = new BatteryProgessBar(new Battery(), skin);
        add(batteryProgessBar);
        row();
        add(new Label("Fuel ", skin));
        FuelProgressBar fuelProgressBar = new FuelProgressBar(new FuelTank(), skin);
        add(fuelProgressBar);
        row();
    }
}
