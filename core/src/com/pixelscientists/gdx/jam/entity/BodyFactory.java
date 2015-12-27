package com.pixelscientists.gdx.jam.entity;

import com.badlogic.gdx.physics.box2d.*;
import com.pixelscientists.gdx.jam.di.DI;

/**
 * @author Daniel Holderbaum
 */
public abstract class BodyFactory {

    public static Body createPlayerBody() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        Body body = DI.getGameComponent().physicsSubSystem().world.createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(1.5f / 2f, 1f / 2f);
        fixtureDef.shape = shape;
        Fixture fixture = body.createFixture(fixtureDef);
        shape.dispose();
        return body;
    }

}
