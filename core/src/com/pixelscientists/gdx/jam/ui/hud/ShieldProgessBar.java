package com.pixelscientists.gdx.jam.ui.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.pixelscientists.gdx.jam.machinery.ship.Shield;

/**
 * @author Daniel Holderbaum
 */
public class ShieldProgessBar extends ProgressBar {

    private Shield shield;

    public ShieldProgessBar(Shield shield, Skin skin) {
        super(0, 1f, 1f / 100f, false, skin);
        this.shield = shield;
        setColor(Color.BLUE);
    }

    @Override
    public void act(float delta) {
        setValue(shield.getShield() / shield.getMaxShield());
        super.act(delta);
    }
}
