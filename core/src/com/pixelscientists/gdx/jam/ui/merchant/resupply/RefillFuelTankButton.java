package com.pixelscientists.gdx.jam.ui.merchant.resupply;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pixelscientists.gdx.jam.machinery.Spaceship;
import com.pixelscientists.gdx.jam.machinery.Store;
import com.pixelscientists.gdx.jam.ui.merchant.BaseMerchantButton;

/**
 * @author Daniel Holderbaum
 */
public class RefillFuelTankButton extends BaseMerchantButton {

    public RefillFuelTankButton(final Spaceship spaceship, final Store store, Skin skin) {
        super("Refill Fuel", spaceship, store, skin);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!isDisabled()) {
                    float maxPurchasableFuel = Math.min(spaceship.getBankAccount().getCredits() / store.getPricePerFuel(), spaceship.getFuelTank().getMissingFuel());
                    float price = maxPurchasableFuel * store.getPricePerFuel();
                    spaceship.getFuelTank().changeFuel(maxPurchasableFuel);
                    spaceship.getBankAccount().changeCredits(-price);
                }
            }
        });
    }
}
