package com.pixelscientists.gdx.jam.ui;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.ui.*;

/**
 * @author Daniel Holderbaum
 */
public class OxygenExtractionDialog extends Dialog {

    private static final Object YES = "yes";
    private static final Object NO = "no";

    public OxygenExtractionDialog(Skin skin) {
        super("Oxygen Extraction", skin);

        text(new Label("Oxygen is being extracted.", skin, "default-font", "default"));

        Button yesButton = new TextButton("Yes", skin, "default");
        Button noButton = new TextButton("No", skin, "default");

        getButtonTable().add(yesButton).size(60, 40);
        getButtonTable().add(noButton).size(60, 40);

        setObject(yesButton, YES);
        setObject(noButton, NO);

        key(Input.Keys.ESCAPE, NO);
        key(Input.Keys.ENTER, YES);
    }

    @Override
    protected void result(Object object) {
        if (YES.equals(object)) {
        } else if (NO.equals(object)) {
            // nothing to do
        } else {
            throw new RuntimeException("The result value '" + object + "' could not be processed.");
        }
    }
}
