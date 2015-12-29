package com.pixelscientists.gdx.jam.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pixelscientists.gdx.commons.physics.box2d.events.BodyActor;
import com.pixelscientists.gdx.jam.di.DI;

/**
 * @author Daniel Holderbaum
 */
public class BlackHole extends BodySpriteEntity {
    public BlackHole(Vector2 position) {
        super(BodyFactory.createBlackHole(3f, position), SpriteFactory.createBlackHole(3f));

        BodyActor bodyActor = DI.getGameComponent().overlaySubSystem().add(body);
        bodyActor.addListener(new InputListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                System.out.print("ENTERED");
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                System.out.print("EXITED");
            }
        });
    }
}
