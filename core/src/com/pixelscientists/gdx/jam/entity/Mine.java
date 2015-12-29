package com.pixelscientists.gdx.jam.entity;

import net.dermetfan.gdx.graphics.g2d.AnimatedSprite;

/**
 * @author Daniel Holderbaum
 */
public class Mine extends BodySpriteEntity {
    public Mine() {
        super(BodyFactory.createMine(0.5f), SpriteFactory.createMine(0.5f));
    }

}
