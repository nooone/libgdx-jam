package com.pixelscientists.gdx.jam.subsystem;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pixelscientists.gdx.commons.physics.box2d.events.BodyActor;

/**
 * @author Daniel Holderbaum
 */
public class OverlaySubsystem implements Disposable {

    public Stage stage;

    public OverlaySubsystem(Viewport gameViewport) {
        stage = new Stage(gameViewport);
    }

    public BodyActor add(Body body) {
        BodyActor bodyActor = new BodyActor(body);
        stage.addActor(bodyActor);
        return bodyActor;
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

}
