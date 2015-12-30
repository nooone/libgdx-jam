package com.pixelscientists.gdx.jam.entity;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;
import com.pixelscientists.gdx.commons.physics.box2d.Box2DUtil;
import com.pixelscientists.gdx.jam.di.DI;

/**
 * @author Daniel Holderbaum
 */
public class BlackHole extends BodySpriteEntity {
    public BlackHole(Vector2 position) {
        super(BodyFactory.createBlackHole(3f, position), SpriteFactory.createBlackHole(3f));
    }

    private Vector2 otherToHole = new Vector2();

    @Override
    public void update(float deltaTime) {
        Array<Body> bodies = Box2DUtil.getBodiesInRadius(DI.getGameComponent().physicsSubSystem().world, body.getPosition(), 5f);
        for (Body otherBody : bodies) {
            otherToHole.set(body.getPosition()).sub(otherBody.getPosition());
            float gravity = 1f / (otherToHole.len() + 0.1f);
            otherBody.applyForceToCenter(otherToHole.scl(gravity), true);
        }
        super.update(deltaTime);
    }
}
