package com.pixelscientists.gdx.jam.entity.enemy;

import com.badlogic.gdx.ai.steer.behaviors.Pursue;
import com.badlogic.gdx.ai.steer.behaviors.Wander;
import com.badlogic.gdx.math.Vector2;
import com.pixelscientists.gdx.jam.di.DI;
import com.pixelscientists.gdx.jam.entity.BodyFactory;
import com.pixelscientists.gdx.jam.entity.SpriteFactory;

/**
 * @author Daniel Holderbaum
 */
public class Drone  extends SteeringEntity {

    public Drone() {
        super(BodyFactory.createPlayer(), SpriteFactory.createPlayer(), false, 5f);
        Wander<Vector2> steeringBehavior = new Wander<Vector2>(this);
        steeringBehavior.setEnabled(true);
        setSteeringBehavior(steeringBehavior);
        setMaxAngularAcceleration(500);
        setMaxAngularSpeed(10000);
        setMaxLinearAcceleration(2);
        setMaxLinearSpeed(5);
    }

}
