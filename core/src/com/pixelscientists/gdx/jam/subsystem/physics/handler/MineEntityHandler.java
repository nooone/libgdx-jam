package com.pixelscientists.gdx.jam.subsystem.physics.handler;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.pixelscientists.gdx.commons.physics.box2d.collision.Box2DContactHandlerAdapter;
import com.pixelscientists.gdx.jam.entity.Entity;
import com.pixelscientists.gdx.jam.entity.Mine;

/**
 * @author Daniel Holderbaum
 */
public class MineEntityHandler extends Box2DContactHandlerAdapter<Mine, Entity> {

    @Override
    public void preSolve(Contact contact, Manifold oldManifold, Mine userDataA, Entity userDataB) {
    }
}
