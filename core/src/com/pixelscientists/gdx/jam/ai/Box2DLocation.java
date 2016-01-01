package com.pixelscientists.gdx.jam.ai;

import com.badlogic.gdx.ai.utils.Location;
import com.badlogic.gdx.math.Vector2;
import com.pixelscientists.gdx.commons.physics.PhysicsUtil;

public class Box2DLocation implements Location<Vector2> {

    private Vector2 position;
    private float orientation;

    public Box2DLocation () {
        this.position = new Vector2();
        this.orientation = 0;
    }

    @Override
    public Vector2 getPosition () {
        return position;
    }

    @Override
    public float getOrientation () {
        return orientation;
    }

    @Override
    public void setOrientation (float orientation) {
        this.orientation = orientation;
    }

    @Override
    public Location<Vector2> newLocation () {
        return new Box2DLocation();
    }

    @Override
    public float vectorToAngle (Vector2 vector) {
        return PhysicsUtil.vectorToAngle(vector);
    }

    @Override
    public Vector2 angleToVector (Vector2 outVector, float angle) {
        return PhysicsUtil.angleToVector(outVector, angle);
    }

}