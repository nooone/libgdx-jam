/* ##########################
 * Copyright 2013 (c) Pixel Scientists
 * All rights reserved.
 * ########################## */
package com.pixelscientists.gdx.jam.subsystem.physics;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Disposable;

import java.util.HashSet;
import java.util.Set;

/**
 * This class loads the Box2D {@link World} and handles the removal of joints and bodies later on. Handles the lists in the following order:
 * <p/>
 * <ul>
 * <li>Removal of Joints</li>
 * <li>Removal of Bodies</li>
 * </ul>
 * <p/>
 * We need to mark the {@link Joint}s and {@link Body}s here for later removal because in the processing step of the {@link World}, we cannot do this. It might happen in this step if there was a manipulation triggered by the {@link ContactListener}.
 *
 * @author Daniel Holderbaum
 */
public class PhysicsSubSystem implements Disposable {

    private static final float TIME_STEP = 1 / 60f;
    private static final int VELOCITY_ITERATIONS = 8;
    private static final int POSITION_ITERATIONS = 2;

    public World world;

    private Set<Joint> jointsToRemove;
    private Set<Body> bodiesToRemove;

    private float accumulator;

    public PhysicsSubSystem() {
        jointsToRemove = new HashSet<Joint>();
        bodiesToRemove = new HashSet<Body>();

        world = new World(new Vector2(0, 0), false);
        world.setContactFilter(new JamContactFilter());
        world.setContactListener(new JamContactListener());

        accumulator = 0.0f;
    }

    /**
     * Marks a {@link Body} as "to be removed".
     *
     * @param bodyToRemove The {@link Body} to remove.
     */
    public synchronized void remove(Body bodyToRemove) {
        bodiesToRemove.add(bodyToRemove);
    }

    /**
     * Marks a {@link Joint} as "to be removed".
     *
     * @param jointToRemove The {@link Joint} to remove.
     */
    public synchronized void remove(Joint jointToRemove) {
        jointsToRemove.add(jointToRemove);
    }

    /**
     * This will update the Box2D {@link World} by performing the physics step and remove the marked {@link Joint}s and {@link Body}s right after that.
     */
    public synchronized void update(float deltaTime) {
        // Joints first because they also get auto-removed when an attached body gets destroyed
        for (Joint jointToRemove : jointsToRemove) {
            world.destroyJoint(jointToRemove);
        }
        jointsToRemove.clear();

        for (Body bodyToRemove : bodiesToRemove) {
            world.destroyBody(bodyToRemove);
        }
        bodiesToRemove.clear();

        doPhysicsStep(deltaTime);
    }

    private void doPhysicsStep(float deltaTime) {
        // Fixed time step
        // Max frame time to avoid spiral of death
        float frameTime = Math.min(deltaTime, 0.25f);
        accumulator += frameTime;
        while (accumulator >= TIME_STEP) {
            world.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
            accumulator -= TIME_STEP;
        }

        // double alpha = accumulator / dt;
        // State state = currentState*alpha + previousState * ( 1.0 - alpha );
    }

    @Override
    public void dispose() {
        world.dispose();
    }
}
