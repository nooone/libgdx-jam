package com.pixelscientists.gdx.jam.screen;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.pixelscientists.gdx.jam.di.DI;

/**
 * @author Daniel Holderbaum
 */
public class PlayerInputProcessor implements InputProcessor {

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
            case Input.Keys.UP:
//                DI.getGameComponent().entitySubSystem().player.accelerate();
                return true;
            case Input.Keys.A:
            case Input.Keys.LEFT:
//                DI.getGameComponent().entitySubSystem().player.turnLeft();
                return true;
            case Input.Keys.D:
            case Input.Keys.RIGHT:
//                DI.getGameComponent().entitySubSystem().player.turnRight();
                return true;
            case Input.Keys.SPACE:

                return true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
