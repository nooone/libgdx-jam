package com.pixelscientists.gdx.jam.ui.hud;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.pixelscientists.gdx.jam.ui.hud.status.ShipStatusWindow;

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
