package com.pixelscientists.gdx.jam.entity.shot;

import com.badlogic.gdx.math.Vector2;
import com.pixelscientists.gdx.jam.entity.BodyFactory;
import com.pixelscientists.gdx.jam.entity.BodySpriteEntity;
import com.pixelscientists.gdx.jam.entity.SpriteFactory;
import net.dermetfan.gdx.graphics.g2d.AnimatedSprite;

/**
 * @author Daniel Holderbaum
 */
public class VulcanShot extends BodySpriteEntity {

    public VulcanShot(Vector2 position, Vector2 direction) {
        super(BodyFactory.createShot(0.2f, position, direction), SpriteFactory.createVulcanShot(0.2f));
    }

}
