package com.pixelscientists.gdx.jam.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.pixelscientists.gdx.jam.entity.shot.ExhaustShot;
import com.pixelscientists.gdx.jam.entity.shot.PlasmaShot;
import com.pixelscientists.gdx.jam.entity.shot.ProtonShot;
import com.pixelscientists.gdx.jam.entity.shot.VulcanShot;

/**
 * @author Daniel Holderbaum
 */
public class Player extends BaseSteerableEntity {

    public Player() {
        super(BodyFactory.createPlayer(), SpriteFactory.createPlayer(), 5f);
    }

    public void accelerate() {
        Vector2 forward = new Vector2(0, 100f * Gdx.graphics.getDeltaTime());
        forward = body.getWorldVector(forward);
        body.applyForceToCenter(forward, true);
    }

    public void turnLeft() {
//        body.applyAngularImpulse(0.2f, true);
        body.applyTorque(100f * Gdx.graphics.getDeltaTime(), true);
    }

    public void turnRight() {
//        body.applyAngularImpulse(-0.2f, true);
        body.applyTorque(-100f * Gdx.graphics.getDeltaTime(), true);
    }

    public void shoot() {
        Vector2 forward = new Vector2(0, 1f);
        forward = body.getWorldVector(forward);
        forward.nor();
//        ExhaustShot leftExhaustShot = new ExhaustShot(body.getPosition(), forward);
        PlasmaShot plasmaShot = new PlasmaShot(body.getPosition().cpy().add(forward.scl(2)), forward);
        VulcanShot vulcanShot = new VulcanShot(body.getPosition(), forward);
        ProtonShot protonShot = new ProtonShot(body.getPosition(), forward);
        ExhaustShot rightExhaustShot = new ExhaustShot(body.getPosition(), forward);
    }

    @Override
    public void update(float deltaTime) {
        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            turnLeft();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) {
            accelerate();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            turnRight();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            shoot();
        }
        super.update(deltaTime);
    }
}
