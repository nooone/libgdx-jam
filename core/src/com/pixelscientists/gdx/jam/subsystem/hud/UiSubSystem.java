package com.pixelscientists.gdx.jam.subsystem.hud;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.pixelscientists.gdx.jam.di.DI;
import com.pixelscientists.gdx.jam.ui.hud.HUD;

/**
 * @author Daniel Holderbaum
 */
public class UiSubSystem implements Disposable {

    public Stage stage;

    public UiSubSystem() {
        stage = new Stage(new ScreenViewport());

        Skin skin = DI.getApplicationComponent().assetManager().get("skins/uiskin.json", Skin.class);
        HUD hud = new HUD(skin);

        stage.addActor(hud);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
