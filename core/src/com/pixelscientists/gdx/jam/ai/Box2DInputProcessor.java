package com.pixelscientists.gdx.jam.ai;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pixelscientists.gdx.jam.di.DI;
import com.pixelscientists.gdx.jam.entity.enemy.SteeringEntity;

public class Box2DInputProcessor extends InputAdapter {

    protected SteeringEntity target;

    public Box2DInputProcessor(SteeringEntity target) {
        this.target = target;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        setTargetPosition(screenX, screenY);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        setTargetPosition(screenX, screenY);
        return true;
    }

    protected void setTargetPosition(int screenX, int screenY) {
        Vector2 screenCoordinates = new Vector2(screenX, screenY);
        Vector2 pos = target.getPosition();
        Viewport gameViewport = DI.getGameComponent().gameViewport();
        gameViewport.unproject(screenCoordinates);
        pos.x = screenCoordinates.x;
        pos.y = screenCoordinates.y;
        target.getBody().setTransform(pos, target.body.getAngle());
    }
}