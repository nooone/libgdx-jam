package com.pixelscientists.gdx.jam.machinery.ship;

import com.pixelscientists.gdx.jam.machinery.BaseUpgradeable;
import com.pixelscientists.gdx.jam.machinery.Upgrade;
import com.pixelscientists.gdx.jam.machinery.Upgradeable;
import com.pixelscientists.gdx.jam.machinery.container.FuelTank;

/**
 * Fuel is used when using the thrusters. Upgrades: Less fuel consumption, faster movement, anti-thruster.
 *
 * @author Daniel Holderbaum
 */
public class Thruster extends BaseUpgradeable<Thruster.ThrusterLevel> {

    public enum ThrusterLevel implements Upgrade {
        NONE(0, 0), BASE(1, 10), UPGRADE_I(1, 20), UPGRADE_II(0.5f, 20);

        ThrusterLevel(float fuelPerSecond, float forcePerSecond) {
            this.fuelPerSecond = fuelPerSecond;
            this.forcePerSecond = forcePerSecond;
        }

        private float fuelPerSecond;

        private float forcePerSecond;

        public float getFuelPerSecond() {
            return fuelPerSecond;
        }

        public float getForcePerSecond() {
            return forcePerSecond;
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

    public Thruster() {
        super(ThrusterLevel.NONE);
    }

    public float thrust(FuelTank fuelTank, float deltaTime) {
        float neededFuel = getFuelPerSecond() * deltaTime;
        float availableFuel = fuelTank.unfill(neededFuel);
        float multiplier = availableFuel / neededFuel;
        return getForcePerSecond() * deltaTime * multiplier;
    }

    public float getFuelPerSecond() {
        return upgrade.getFuelPerSecond();
    }

    public float getForcePerSecond() {
        return upgrade.getForcePerSecond();
    }
}
