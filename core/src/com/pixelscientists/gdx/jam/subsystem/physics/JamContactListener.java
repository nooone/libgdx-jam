package com.pixelscientists.gdx.jam.subsystem.physics;

import com.pixelscientists.gdx.commons.physics.box2d.collision.Box2DContactListener;
import com.pixelscientists.gdx.commons.physics.box2d.collision.ContactHandlerInformation;
import com.pixelscientists.gdx.jam.entity.Entity;
import com.pixelscientists.gdx.jam.entity.Mine;
import com.pixelscientists.gdx.jam.subsystem.physics.handler.MineEntityHandler;

/**
 * Created by noone on 27.12.2015.
 */
public class JamContactListener extends Box2DContactListener {

    public JamContactListener() {
        addContactHandler(new ContactHandlerInformation(Mine.class, Entity.class, new MineEntityHandler()));
    }
}
