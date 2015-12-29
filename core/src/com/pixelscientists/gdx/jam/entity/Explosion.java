package com.pixelscientists.gdx.jam.entity;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;

/**
 * @author Daniel Holderbaum
 */
public class Explosion {

    private Array<Body> particles = new Array<Body>();

    private float timeToLive = 1.5f;

    private float renderTime = 0.f;

    private Animation animation;

    /**
     * In physics units.
     */
    private Vector2 center;

//    public Explosion(Vector2 center, float blastPower, int numRays) {
//        this.center = center;
//        particles = BodyFactory.createExplosionBodies(center, blastPower, numRays);
//        setUserData(particles);
//
//        Texture tex = Racer.assets.get("explosion.png", Texture.class);
//        TextureRegion[][] tiles = TextureRegion.split(tex, 42, 42);
//        animation = new Animation(0.05f, tiles[0]);
//    }
//
//    public Explosion(Vector2 center, float blastPower, float blastRadius) {
//        proximityBased(new Vector2(center), blastRadius, blastPower);
//        this.center = center;
//
//        Texture tex = Racer.assets.get("explosion.png", Texture.class);
//        TextureRegion[][] tiles = TextureRegion.split(tex, 42, 42);
//        animation = new Animation(0.05f, tiles[0]);
//    }
//
//    public Explosion(Vector2 center, float blastPower, float blastRadius, int numRays) {
//        raycastMethod(new Vector2(center), blastRadius, blastPower, numRays);
//        this.center = center;
//
//        Texture tex = Racer.assets.get("explosion.png", Texture.class);
//        TextureRegion[][] tiles = TextureRegion.split(tex, 42, 42);
//        animation = new Animation(0.05f, tiles[0]);
//    }
//
//    @Override
//    public void update(float deltaTime) {
//        if (timeToLive <= 0f) {
//            for (Body particle : particles) {
//                WorldManager.remove(particle);
//            }
//            particles.clear();
//
//        }
//        if (timeToLive <= 0f && animation.isAnimationFinished(renderTime)) {
//            EntityManager.removeEntity(this);
//        }
//
//        timeToLive -= deltaTime;
//    }
//
//    private void proximityBased(Vector2 center, float blastRadius, float blastPower) {
//        // Find all bodies with fixtures in blast radius AABB
//        SimpleQueryCallback queryCallback = new SimpleQueryCallback(true);
//        WorldManager.world.QueryAABB(queryCallback, center.x - blastRadius, center.y - blastRadius, center.x + blastRadius, center.y + blastRadius);
//
//        // Check which of these bodies have their center of mass within the blast radius
//        for (Body body : queryCallback.bodies) {
//            Vector2 bodyCom = body.getWorldCenter();
//
//            // Ignore bodies outside the blast range
//            if ((bodyCom.sub(center)).len() >= blastRadius) {
//                continue;
//            }
//
//            applyBlastImpulse(body, center, bodyCom, blastPower);
//        }
//    }
//
//    private void raycastMethod(Vector2 center, float blastRadius, float blastPower, int numRays) {
//        for (int i = 0; i < numRays; i++) {
//            float angle = (i / (float) numRays) * 360 * MathUtils.degreesToRadians;
//            Vector2 rayDir = new Vector2(MathUtils.sin(angle), MathUtils.cos(angle));
//            Vector2 rayEnd = new Vector2(rayDir).scl(blastRadius).add(center);
//
//            // check what this ray hits
//            ClosestRayCastCallback callback = new ClosestRayCastCallback();
//            DI.getGameComponent().physicsSubSystem().world.rayCast(callback, center, rayEnd);
//            if (callback.collision != null) {
//                applyBlastImpulse(callback.collision.fixture.getBody(), center, callback.collision.point, (blastPower / (float) numRays));
//            }
//        }
//    }
//
//    /**
//     * @param body        Body to apply the blast impulse on.
//     * @param blastCenter Modifiable.
//     * @param applyPoint  Modifiable.
//     * @param blastPower
//     */
//    private void applyBlastImpulse(Body body, Vector2 blastCenter, Vector2 applyPoint, float blastPower) {
//        Vector2 blastDir = applyPoint.sub(blastCenter);
//        float distance = blastDir.len();
//
//        // ignore bodies exactly at the blast point - blast direction is
//        // undefined
//        if (distance == 0) {
//            return;
//        }
//
//        blastDir.nor(); // needed?
//        float invDistance = 1 / distance;
//        float impulseMag = blastPower * invDistance * invDistance;
//        body.applyLinearImpulse(blastDir.scl(impulseMag), applyPoint, true);
//    }
//
//    @Override
//    public void render() {
//        if (!animation.isAnimationFinished(renderTime)) {
//            TextureRegion current = animation.getKeyFrame(renderTime);
//            DI.getApplicationComponent().spriteBatch().draw(current, center.x * -current.getRegionWidth() / 2f, center.y * -current.getRegionHeight() / 2f);
//        }
//
//        renderTime += deltaTime;
//    }
}
