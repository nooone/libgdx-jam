package com.pixelscientists.gdx.jam.ui.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.pixelscientists.gdx.jam.machinery.container.Battery;
import com.pixelscientists.gdx.jam.machinery.ship.Hull;

/**
 * @author Daniel Holderbaum
 */
public class BatteryProgessBar extends ProgressBar {

    private Battery battery;

    public BatteryProgessBar(Battery battery, Skin skin) {
        super(0, 1f, 1f / 100f, false, skin);
        this.battery = battery;
        setColor(Color.YELLOW);
    }

    @Override
    public void act(float delta) {
        setValue(battery.getEnergy() / battery.getMaxEnergy());
        super.act(delta);
    }
}
