package com.pixelscientists.gdx.jam.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.pixelscientists.gdx.jam.di.DI;

/**
 * @author Daniel Holderbaum
 */
public class Player extends BodySpriteEntity {

    public Player() {
        super(BodyFactory.createPlayerBody(), SpriteFactory.createPlayerSprite());
    }

    public void accelerate() {
        Vector2 forward = new Vector2(0, 1f);
        forward = body.getWorldVector(forward);
        body.applyForceToCenter(forward, true);
    }

    public void turnLeft() {
//        body.applyAngularImpulse(0.2f, true);
        body.applyTorque(1f, true);
    }

    public void turnRight() {
//        body.applyAngularImpulse(-0.2f, true);
        body.applyTorque(-1f, true);
    }
}
