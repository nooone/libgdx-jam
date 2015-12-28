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
public class BodySpriteEntity extends Entity {

    public Body body;

    protected Sprite sprite;

    public BodySpriteEntity(Body body, Sprite sprite) {
        this.body = body;
        this.sprite = sprite;
        body.setUserData(this);
    }

    @Override
    public void render() {
        sprite.draw(DI.getApplicationComponent().spriteBatch());
    }

    @Override
    public void update(float deltaTime) {
        sprite.setPosition(body.getPosition().x, body.getPosition().y);
        sprite.translate(-sprite.getWidth() / 2f, -sprite.getHeight() / 2f);
        sprite.setRotation(body.getAngle() * MathUtils.radiansToDegrees);
        sprite.setOriginCenter();
    }

    @Override
    public void dispose() {
        DI.getGameComponent().physicsSubSystem().remove(body);
    }
}
