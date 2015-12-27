package com.pixelscientists.gdx.jam.subsystem.hud;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * @author Daniel Holderbaum
 */
public class HudSubSystem implements Disposable {

    public Stage stage;

    public HudSubSystem() {
        stage = new Stage(new ScreenViewport());

        Table rootTable = new Table();
        rootTable.setFillParent(true);

        stage.addActor(rootTable);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
