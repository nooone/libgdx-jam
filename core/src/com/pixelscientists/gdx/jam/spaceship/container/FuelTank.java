package com.pixelscientists.gdx.jam.spaceship.container;

import com.pixelscientists.gdx.jam.spaceship.BaseUpgradeable;
import com.pixelscientists.gdx.jam.spaceship.Upgrade;

/**
 * @author Daniel Holderbaum
 */
public class FuelTank extends BaseUpgradeable<FuelTank.FuelTankLevel> {

    public enum FuelTankLevel implements Upgrade {
        NONE(0), BASE(300), UPGRADE_I(500), UPGRADE_II(1000);

        FuelTankLevel(float maxFuel) {
            this.maxFuel = maxFuel;
        }

        private final float maxFuel;

        public float getMaxFuel() {
            return maxFuel;
        }

        @Override
        public float getPrice() {
            return BaseUpgradeable.getPrice(this);
        }

        @Override
        public Upgrade getNext() {
            return BaseUpgradeable.getNext(this);
        }
    }

    private float fuel = upgrade.maxFuel;

    public FuelTank() {
        super(FuelTankLevel.NONE);
    }

    public void fill(float newFuel) {
        assert newFuel >= 0;
        fuel += newFuel;
        fuel = Math.min(fuel, getMaxFuel());
    }

    public float unfill(float wantedFuel) {
        assert wantedFuel >= 0;
        float returnedFuel = Math.min(wantedFuel, fuel);
        fuel -= returnedFuel;
        return returnedFuel;
    }

    public boolean isEmpty() {
        return fuel <= 0;
    }

    public float getFuel() {
        return fuel;
    }

    public void changeFuel(float deltaFuel) {
        fuel += deltaFuel;
    }

    public float getMaxFuel() {
        return upgrade.getMaxFuel();
    }

    public float getMissingFuel() {
        return upgrade.getMaxFuel() - fuel;
    }

}
