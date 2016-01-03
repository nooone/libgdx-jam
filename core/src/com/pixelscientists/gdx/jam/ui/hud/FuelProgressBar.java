package com.pixelscientists.gdx.jam.ui.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.pixelscientists.gdx.jam.machinery.container.Battery;
import com.pixelscientists.gdx.jam.machinery.container.FuelTank;

/**
 * @author Daniel Holderbaum
 */
public class FuelProgressBar extends ProgressBar {

    private FuelTank fuelTank;

    public FuelProgressBar(FuelTank fuelTank, Skin skin) {
        super(0, 1f, 1f / 100f, false, skin);
        this.fuelTank = fuelTank;
        setColor(Color.GREEN);
    }

    @Override
    public void act(float delta) {
        setValue(fuelTank.getFuel() / fuelTank.getMaxFuel());
        super.act(delta);
    }
}
