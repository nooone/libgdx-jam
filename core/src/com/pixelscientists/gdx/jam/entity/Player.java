package com.pixelscientists.gdx.jam.entity;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * @author Daniel Holderbaum
 */
public class Player {

    public Body body;

    public Player() {
        body = BodyFactory.createPlayerBody();
        body.setUserData(this);
    }

    public void accelerate() {
        Vector2 forward = new Vector2(0, 100f);
        body.applyForceToCenter(forward, true);
    }

    public void turnLeft() {
//        body.applyAngularImpulse(-100, true);
        body.applyTorque(100, true);
    }

    public void turnRight() {
        body.applyAngularImpulse(100, true);
    }

}
