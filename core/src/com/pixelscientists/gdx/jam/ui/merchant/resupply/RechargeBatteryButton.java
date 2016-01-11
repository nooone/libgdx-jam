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
public class RechargeBatteryButton extends BaseMerchantButton {

    public RechargeBatteryButton(final Spaceship spaceship, final Store store, Skin skin) {
        super("Recharge Battery", spaceship, store, skin);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!isDisabled()) {
                    float maxRechargableEnergy = Math.min(spaceship.getBankAccount().getCredits() / store.getPricePerEnergy(), spaceship.getBattery().getMissingEnergy());
                    float price = maxRechargableEnergy * store.getPricePerEnergy();
                    spaceship.getBattery().charge(maxRechargableEnergy);
                    spaceship.getBankAccount().changeCredits(-price);
                }
            }
        });
    }
}
