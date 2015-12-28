package com.pixelscientists.gdx.jam.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * @author Daniel Holderbaum
 */
public abstract class SpriteFactory {

    public static Sprite createPlayerSprite() {
        Sprite sprite = new Sprite(new Texture("ships/Ship (4).png"));
        sprite.setSize(1.5f, 1f);
        return sprite;
    }

}
