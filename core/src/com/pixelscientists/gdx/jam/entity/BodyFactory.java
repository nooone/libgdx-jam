package com.pixelscientists.gdx.jam.entity;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.pixelscientists.gdx.commons.physics.PhysicsUtil;
import com.pixelscientists.gdx.jam.di.DI;

/**
 * @author Daniel Holderbaum
 */
public abstract class BodyFactory {

    public static Body createPlayer() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.allowSleep = false;
        bodyDef.angularDamping = 0.2f;
        bodyDef.linearDamping = 0.2f;
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        Body body = DI.getGameComponent().physicsSubSystem().world.createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(3f / 2f, 2f / 2f);
        fixtureDef.shape = shape;
        fixtureDef.density = 0.1f;
        Fixture fixture = body.createFixture(fixtureDef);
        shape.dispose();
        return body;
    }

    public static Body createAsteroid(float size) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.allowSleep = false;
        bodyDef.angularDamping = 0.2f;
        bodyDef.linearDamping = 0.2f;
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        Body body = DI.getGameComponent().physicsSubSystem().world.createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(size / 2f);
        fixtureDef.shape = shape;
        fixtureDef.density = 0.1f;
        Fixture fixture = body.createFixture(fixtureDef);
        shape.dispose();
        return body;
    }

    public static Body createMine(float size) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.allowSleep = false;
        bodyDef.angularDamping = 0.2f;
        bodyDef.linearDamping = 0.2f;
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        Body body = DI.getGameComponent().physicsSubSystem().world.createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(size / 2f);
        fixtureDef.shape = shape;
        fixtureDef.density = 0.1f;
        Fixture fixture = body.createFixture(fixtureDef);
        shape.dispose();
        return body;
    }

    public static Body createShot(float size, Vector2 position, Vector2 direction) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.allowSleep = false;
        bodyDef.angularDamping = 0f;
        bodyDef.linearDamping = 0f;
        bodyDef.fixedRotation = true;
        bodyDef.angle = direction.angle() * MathUtils.degreesToRadians - MathUtils.PI / 2f;
        bodyDef.bullet = true;
        float speed = 10f;
        bodyDef.linearVelocity.set(direction).nor().scl(speed);
        bodyDef.position.set(position);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        Body body = DI.getGameComponent().physicsSubSystem().world.createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(size / 2f);
        fixtureDef.shape = shape;
        fixtureDef.density = 0.1f;
        Fixture fixture = body.createFixture(fixtureDef);
        shape.dispose();
        return body;
    }

    public static Body createBlackHole(float size, Vector2 position) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.allowSleep = false;
        bodyDef.angularVelocity = -0.2f;
        bodyDef.angularDamping = 0f;
        bodyDef.position.set(position);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        Body body = DI.getGameComponent().physicsSubSystem().world.createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.isSensor = true;
        CircleShape shape = new CircleShape();
        shape.setRadius(size / 2f);
        fixtureDef.shape = shape;
        fixtureDef.density = 0.1f;
        Fixture fixture = body.createFixture(fixtureDef);
        shape.dispose();
        return body;
    }

    public static Body createOuterSpace(float size) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        Body body = DI.getGameComponent().physicsSubSystem().world.createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(3f / 2f, 2f / 2f);
        fixtureDef.shape = shape;
        Fixture fixture = body.createFixture(fixtureDef);
        shape.dispose();
        return body;
    }

    public static Array<Body> createExplosionBodies(final Vector2 center, float blastPower, int numRays) {
        Array<Body> bodies = new Array<Body>();

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.fixedRotation = true;
        // prevent tunneling at high speed
        bodyDef.bullet = true;
        // drag due to moving through air
        bodyDef.linearDamping = 10;
        bodyDef.gravityScale = 0;
        bodyDef.position.set(center);

        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(0.05f);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circleShape;
        // very high - shared across all particles
        fixtureDef.density = 60 / (float) numRays;
        fixtureDef.friction = 0;
        // high restitution to reflect off obstacles
        fixtureDef.restitution = 0.99f;
        // particles should not collide with each other
        fixtureDef.filter.groupIndex = -1;

        for (int i = 0; i < numRays; i++) {
            float angle = (i / (float) numRays) * 360 * MathUtils.degreesToRadians;
            Vector2 rayDirection = new Vector2(MathUtils.sin(angle), MathUtils.cos(angle));

            bodyDef.linearVelocity.set(rayDirection.scl(blastPower));
            Body body = DI.getGameComponent().physicsSubSystem().world.createBody(bodyDef);
            body.createFixture(fixtureDef);

            bodies.add(body);
        }

        circleShape.dispose();

        return bodies;
    }

}
