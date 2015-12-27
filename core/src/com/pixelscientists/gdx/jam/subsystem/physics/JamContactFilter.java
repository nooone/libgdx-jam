package com.pixelscientists.gdx.jam.subsystem.physics;

import com.pixelscientists.gdx.commons.physics.box2d.collision.Box2DContactFilter;

/**
 * Created by noone on 27.12.2015.
 */
public class JamContactFilter extends Box2DContactFilter {

    public JamContactFilter() {
        super(false);
    }

}
