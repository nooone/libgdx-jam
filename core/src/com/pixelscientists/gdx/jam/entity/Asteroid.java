package com.pixelscientists.gdx.jam.entity;

/**
 * @author Daniel Holderbaum
 */
public class Asteroid extends BaseSteerableEntity {

    public Asteroid(float size) {
        super(BodyFactory.createAsteroid(size), SpriteFactory.createAsteroid(size), size);
    }
}
