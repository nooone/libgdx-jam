package com.pixelscientists.gdx.jam.ui.merchant;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pixelscientists.gdx.jam.machinery.Upgradeable;

/**
 * @author Daniel Holderbaum
 */
public class UpgradeButton extends TextButton {

    public UpgradeButton(Upgradeable<?> upgradeable, Skin skin) {
        super(upgradeable.getCurrentUpgrade().toString(), skin);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });
    }

}
