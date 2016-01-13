package com.pixelscientists.gdx.jam.ui.merchant.resupply;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pixelscientists.gdx.jam.spaceship.Spaceship;
import com.pixelscientists.gdx.jam.spaceship.Store;
import com.pixelscientists.gdx.jam.ui.merchant.BaseMerchantButton;

/**
 * @author Daniel Holderbaum
 */
public class RefillOxygenTankButton extends BaseMerchantButton {

    public RefillOxygenTankButton(final Spaceship spaceship, final Store store, Skin skin) {
        super("Refill Oxygen", spaceship, store, skin);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!isDisabled()) {
                    float maxPurchasableOxygen = Math.min(spaceship.getBankAccount().getCredits() / store.getPricePerOxygen(), spaceship.getOxygenTank().getMissingOxygen());
                    float price = maxPurchasableOxygen * store.getPricePerOxygen();
                    spaceship.getOxygenTank().fill(maxPurchasableOxygen);
                    spaceship.getBankAccount().withdraw(price);
                }
            }
        });
    }
}
