package com.pixelscientists.gdx.jam.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import net.dermetfan.gdx.graphics.g2d.*;
import net.dermetfan.gdx.graphics.g2d.AnimatedSprite;

/**
 * @author Daniel Holderbaum
 */
public abstract class SpriteFactory {

    public static Sprite createPlayer() {
        Texture texture = new Texture("textures/ships/Ship (4).png");
        Sprite sprite = new Sprite(texture);
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        float size = 3f;
        sprite.setSize(size, size * texture.getHeight() / texture.getWidth());
        return sprite;
    }

    public static Sprite createAsteroid(float size) {
        Texture texture = new Texture("textures/asteroids/asteroid_" + MathUtils.random(1, 14) + ".png");
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Sprite sprite = new Sprite(texture);
        sprite.setSize(size, size * texture.getHeight() / texture.getWidth());
        return sprite;
    }

    public static Sprite createMine(float size) {
        Array<TextureRegion> regions = new Array<TextureRegion>();
        regions.add(new TextureRegion(new Texture("textures/mines/mine_2/mine_2_01.png")));
        regions.add(new TextureRegion(new Texture("textures/mines/mine_2/mine_2_02.png")));
        regions.add(new TextureRegion(new Texture("textures/mines/mine_2/mine_2_03.png")));
        regions.add(new TextureRegion(new Texture("textures/mines/mine_2/mine_2_04.png")));
        for (TextureRegion region : regions) {
            region.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }
        Animation animation = new Animation(0.5f, regions, Animation.PlayMode.LOOP);
        AnimatedSprite animatedSprite = new AnimatedSprite(animation);
        animatedSprite.setSize(size, size);
        return animatedSprite;
    }

    public static Sprite createExhaustShot(float size) {
        Texture texture = new Texture("textures/bullets/exhaust/exhaust_01.png");
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Sprite sprite = new Sprite(texture);
        setSpriteSize(sprite, size);
//        sprite.setSize(width, width * texture.getHeight() / texture.getWidth());
        return sprite;

//        Array<TextureRegion> regions = new Array<TextureRegion>();
//        regions.add(new TextureRegion(new Texture("textures/bullets/exhaust/exhaust_01.png")));
//        regions.add(new TextureRegion(new Texture("textures/bullets/exhaust/exhaust_02.png")));
//        regions.add(new TextureRegion(new Texture("textures/bullets/exhaust/exhaust_03.png")));
//        regions.add(new TextureRegion(new Texture("textures/bullets/exhaust/exhaust_04.png")));
//        for (TextureRegion region : regions) {
//            region.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
//        }
//        Animation animation = new Animation(0.2f, regions, Animation.PlayMode.LOOP);
//        AnimatedSprite animatedSprite = new AnimatedSprite(animation);
//        animatedSprite.setSize(size, size * regions.get(0).getRegionHeight() / regions.get(0).getRegionWidth());
//        return animatedSprite;
    }

    public static Sprite createVulcanShot(float size) {
        Texture texture = new Texture("textures/bullets/vulcan/vulcan_1.png");
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Sprite sprite = new Sprite(texture);
        setSpriteSize(sprite, size);
        return sprite;

//        Array<TextureRegion> regions = new Array<TextureRegion>();
//        regions.add(new TextureRegion(new Texture("textures/bullets/vulcan/vulcan_1.png")));
//        regions.add(new TextureRegion(new Texture("textures/bullets/vulcan/vulcan_2.png")));
//        regions.add(new TextureRegion(new Texture("textures/bullets/vulcan/vulcan_3.png")));
//        for (TextureRegion region : regions) {
//            region.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
//        }
//        Animation animation = new Animation(0.2f, regions, Animation.PlayMode.LOOP);
//        AnimatedSprite animatedSprite = new AnimatedSprite(animation);
//        animatedSprite.setAutoUpdate(false);
//        animatedSprite.setSize(size, size * regions.get(0).getRegionHeight() / regions.get(0).getRegionWidth());
//        return animatedSprite;
    }

    public static Sprite createPlasmaShot(float size) {
        Texture texture = new Texture("textures/bullets/plasma/plasma_1.png");
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Sprite sprite = new Sprite(texture);
        setSpriteSize(sprite, size);
        return sprite;

//        Array<TextureRegion> regions = new Array<TextureRegion>();
//        regions.add(new TextureRegion(new Texture("textures/bullets/plasma/plasma_1.png")));
//        regions.add(new TextureRegion(new Texture("textures/bullets/plasma/plasma_2.png")));
//        for (TextureRegion region : regions) {
//            region.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
//        }
//        Animation animation = new Animation(0.2f, regions, Animation.PlayMode.LOOP);
//        AnimatedSprite animatedSprite = new AnimatedSprite(animation);
//        animatedSprite.setAutoUpdate(false);
//        animatedSprite.setUseFrameRegionSize(true);
//        animatedSprite.setSize(size, size * regions.get(0).getRegionHeight() / regions.get(0).getRegionWidth());
//        return animatedSprite;
    }

    public static Sprite createProtonShot(float size) {
        Texture texture = new Texture("textures/bullets/proton/proton_01.png");
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Sprite sprite = new Sprite(texture);
        setSpriteSize(sprite, size);
        return sprite;

//        Array<TextureRegion> regions = new Array<TextureRegion>();
//        regions.add(new TextureRegion(new Texture("textures/bullets/proton/proton_01.png")));
//        regions.add(new TextureRegion(new Texture("textures/bullets/proton/proton_02.png")));
//        regions.add(new TextureRegion(new Texture("textures/bullets/proton/proton_03.png")));
//        for (TextureRegion region : regions) {
//            region.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
//        }
//        Animation animation = new Animation(0.2f, regions, Animation.PlayMode.LOOP);
//        AnimatedSprite animatedSprite = new AnimatedSprite(animation);
//        animatedSprite.setAutoUpdate(false);
//        animatedSprite.setSize(size, size * regions.get(0).getRegionHeight() / regions.get(0).getRegionWidth());
//        return animatedSprite;
    }

    public static Sprite createBlackHole(float size) {
        Texture texture = new Texture("textures/pres2.png");
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Sprite sprite = new Sprite(texture);
        setSpriteSize(sprite, size);
        return sprite;
    }

    private static void setSpriteSize(Sprite sprite, float size) {
        if (sprite.getRegionWidth() >= sprite.getRegionHeight()) {
            sprite.setSize(size, size * sprite.getRegionHeight() / sprite.getRegionWidth());
        } else {
            sprite.setSize(size * sprite.getRegionWidth() / sprite.getRegionHeight(), size);
        }
    }

}
