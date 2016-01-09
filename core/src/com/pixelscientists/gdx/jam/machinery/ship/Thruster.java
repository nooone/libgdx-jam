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
public class Thruster implements Upgradeable<Thruster.ThrusterLevel> {

    public enum ThrusterLevel implements Upgrade {
        BASE(300, 100), UPGRADE_I(500, 100), UPGRADE_II(1000, 100);

        ThrusterLevel(float fuelConsumptionPerSecond, float forcePerSecond) {
            this.fuelConsumptionPerSecond = fuelConsumptionPerSecond;
            this.forcePerSecond = forcePerSecond;
        }

        private float fuelConsumptionPerSecond;

        private float forcePerSecond;

        public float getFuelConsumptionPerSecond() {
            return fuelConsumptionPerSecond;
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

    private ThrusterLevel thrusterLevel = ThrusterLevel.BASE;

    public float thrust(FuelTank fuelTank, float deltaTime) {
        float neededFuel = getFuelPerSecond() * deltaTime;
        float availableFuel = fuelTank.unfill(neededFuel);
        float multiplier = availableFuel / neededFuel;
        return getForcePerSecond() * deltaTime * multiplier;
    }

    @Override
    public ThrusterLevel getCurrentUpgrade() {
        return thrusterLevel;
    }

    public float getFuelPerSecond() {
        return thrusterLevel.getFuelConsumptionPerSecond();
    }

    public float getForcePerSecond() {
        return thrusterLevel.getForcePerSecond();
    }
}
