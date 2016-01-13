package com.pixelscientists.gdx.jam.spaceship;

import com.badlogic.gdx.utils.Array;

/**
 * @author Daniel Holderbaum
 */
public class Store {

    private float pricePerFuel;
    private float pricePerOxygen;
    private float pricePerEnergy;

    private Array<Upgradeable> availableUpgradeables = new Array<Upgradeable>();

    public Store(Spaceship spaceship) {
        Array<Upgradeable> allUpgradeables = new Array<Upgradeable>(spaceship.getUpgradeables());
        allUpgradeables.shuffle();
        for (int i = 0; i < 3; i++) {
            availableUpgradeables.add(allUpgradeables.get(i));
        }
    }

    public float getPricePerFuel() {
        return pricePerFuel;
    }

    public float getPricePerOxygen() {
        return pricePerOxygen;
    }

    public float getPricePerEnergy() {
        return pricePerEnergy;
    }

    public Array<Upgradeable> getAvailableUpgradeables() {
        return availableUpgradeables;
    }
}
