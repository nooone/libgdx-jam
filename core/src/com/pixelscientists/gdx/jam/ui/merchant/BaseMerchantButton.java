package com.pixelscientists.gdx.jam.ui.merchant;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.pixelscientists.gdx.jam.spaceship.Spaceship;
import com.pixelscientists.gdx.jam.spaceship.Store;

/**
 * @author Daniel Holderbaum
 */
public class BaseMerchantButton extends TextButton {

    protected Spaceship spaceship;
    protected Store store;

    public BaseMerchantButton(String text, Spaceship spaceship, Store store, Skin skin) {
        super(text, skin);
        this.spaceship = spaceship;
        this.store = store;
    }

}
