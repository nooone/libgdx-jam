package com.pixelscientists.gdx.jam.ui.merchant;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pixelscientists.gdx.jam.spaceship.Spaceship;
import com.pixelscientists.gdx.jam.spaceship.Upgrade;
import com.pixelscientists.gdx.jam.spaceship.Upgradeable;
import com.pixelscientists.gdx.jam.spaceship.container.BankAccount;

/**
 * @author Daniel Holderbaum
 */
public class UpgradeButton extends TextButton {

    private Spaceship spaceship;
    private Upgradeable<?> upgradeable;

    public UpgradeButton(Upgradeable<?> upgradeable, Skin skin) {
        super(upgradeable.getCurrentUpgrade().toString(), skin);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!isDisabled()) {
                    BankAccount bankAccount = null;
                    bankAccount.withdraw(upgradeable.getCurrentUpgrade().getNext().getPrice());
                    upgradeable.upgrade();
                }
            }
        });
    }

    @Override
    public void act(float delta) {
        Upgrade nextUpgrade = upgradeable.getCurrentUpgrade().getNext();
        if (nextUpgrade != null) {
            BankAccount bankAccount = null;
            setDisabled(bankAccount.getCredits() < nextUpgrade.getPrice());
        } else {
            setDisabled(true);
        }
        super.act(delta);
    }
}
