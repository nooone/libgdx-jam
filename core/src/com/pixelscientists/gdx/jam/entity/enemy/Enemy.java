package com.pixelscientists.gdx.jam.entity.enemy;

import com.badlogic.gdx.ai.steer.SteeringBehavior;
import com.badlogic.gdx.ai.steer.behaviors.Pursue;
import com.badlogic.gdx.math.Vector2;
import com.pixelscientists.gdx.jam.di.DI;
import com.pixelscientists.gdx.jam.entity.BodyFactory;
import com.pixelscientists.gdx.jam.entity.SpriteFactory;

/**
 * @author Daniel Holderbaum
 */
public class Enemy extends SteeringEntity {

    public Enemy() {
        super(BodyFactory.createPlayer(), SpriteFactory.createPlayer(), false, 5f);
        SteeringBehavior<Vector2> steeringBehavior = new Pursue<Vector2>(this, DI.getGameComponent().entitySubSystem().player);
        setSteeringBehavior(steeringBehavior);
    }

//    @Override
//    public void update(float deltaTime) {
//        super.update(deltaTime);
//    }
}
