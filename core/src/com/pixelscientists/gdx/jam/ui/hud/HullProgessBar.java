package com.pixelscientists.gdx.jam.ui.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.pixelscientists.gdx.jam.machinery.ship.Hull;

/**
 * @author Daniel Holderbaum
 */
public class HullProgessBar extends ProgressBar {

    private Hull hull;

    public HullProgessBar(Hull hull, Skin skin) {
        super(0, 1f, 1f / 100f, false, skin);
        this.hull = hull;
        setColor(Color.RED);
    }

    @Override
    public void act(float delta) {
        setValue(hull.getHealth() / hull.getMaxHealth());
        super.act(delta);
    }
}
