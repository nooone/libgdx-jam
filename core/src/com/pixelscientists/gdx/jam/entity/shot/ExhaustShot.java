package com.pixelscientists.gdx.jam.entity.shot;

import com.badlogic.gdx.math.Vector2;
import com.pixelscientists.gdx.jam.entity.BodyFactory;
import com.pixelscientists.gdx.jam.entity.BodySpriteEntity;
import com.pixelscientists.gdx.jam.entity.SpriteFactory;

/**
 * @author Daniel Holderbaum
 */
public class ExhaustShot extends BodySpriteEntity {

    public ExhaustShot(Vector2 position, Vector2 direction) {
        super(BodyFactory.createShot(0.2f, position, direction), SpriteFactory.createExhaustShot(0.5f));
    }

}
