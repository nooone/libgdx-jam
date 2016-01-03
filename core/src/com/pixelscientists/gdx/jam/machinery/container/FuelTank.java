package com.pixelscientists.gdx.jam.machinery.container;

import com.pixelscientists.gdx.jam.machinery.BaseUpgradeable;
import com.pixelscientists.gdx.jam.machinery.Upgrade;
import com.pixelscientists.gdx.jam.machinery.Upgradeable;

/**
 * @author Daniel Holderbaum
 */
public class FuelTank implements Upgradeable<FuelTank.FuelTankLevel> {

    public enum FuelTankLevel implements Upgrade {
        BASE(300), UPGRADE_I(500), UPGRADE_II(1000);

        FuelTankLevel(float maxFuel) {
            this.maxFuel = maxFuel;
        }

        private final float maxFuel;

        public float getMaxFuel() {
            return maxFuel;
        }

        @Override
        public int getPrice() {
            return BaseUpgradeable.getPrice(this);
        }

        @Override
        public Upgrade getNext() {
            return BaseUpgradeable.getNext(this);
        }
    }

    private FuelTankLevel fuelTankLevel = FuelTankLevel.BASE;
    private float fuel = fuelTankLevel.maxFuel;


    @Override
    public FuelTankLevel getCurrentUpgrade() {
        return fuelTankLevel;
    }

    public boolean isEmpty() {
        return fuel <= 0;
    }

    public FuelTankLevel getFuelTankLevel() {
        return fuelTankLevel;
    }

    public float getFuel() {
        return fuel;
    }

    public void changeFuel(float deltaFuel) {
        fuel += deltaFuel;
    }

    public float getMaxFuel() {
        return fuelTankLevel.getMaxFuel();
    }

    public float getMissingFuel() {
        return fuelTankLevel.getMaxFuel() - fuel;
    }

}
