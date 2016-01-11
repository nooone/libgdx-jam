package com.pixelscientists.gdx.jam.spaceship.generator;

import com.pixelscientists.gdx.jam.spaceship.BaseUpgradeable;
import com.pixelscientists.gdx.jam.spaceship.Upgrade;
import com.pixelscientists.gdx.jam.spaceship.container.Battery;
import com.pixelscientists.gdx.jam.spaceship.container.FuelTank;
import com.pixelscientists.gdx.jam.spaceship.container.OxygenTank;

/**
 * @author Daniel Holderbaum
 */
public class Generator extends BaseUpgradeable<Generator.GeneratorLevel> {

    public enum GeneratorLevel implements Upgrade {
        NONE(0, 0, 0), BASE(300, 100, 100), UPGRADE_I(500, 100, 100), UPGRADE_II(1000, 100, 100);

        GeneratorLevel(float fuelPerSecond, float energyPerSecond, float oxygenPerSecond) {
            this.fuelPerSecond = fuelPerSecond;
            this.energyPerSecond = energyPerSecond;
            this.oxygenPerSecond = oxygenPerSecond;
        }

        private float fuelPerSecond;
        private float energyPerSecond;
        private float oxygenPerSecond;

        public float getOxygenPerSecond() {
            return oxygenPerSecond;
        }

        public float getEnergyPerSecond() {
            return energyPerSecond;
        }

        public float getFuelPerSecond() {
            return fuelPerSecond;
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

    public Generator() {
        super(GeneratorLevel.BASE);
    }

    public void burn(OxygenTank oxygenTank, Battery battery, float deltaTime) {
        float oxygenToBurn = getOxygenPerSecond() * deltaTime;
        float availableOxygen = oxygenTank.unfill(oxygenToBurn);
        float multiplier = oxygenToBurn / availableOxygen;
        battery.charge(getEnergyPerSecond() * deltaTime * multiplier);
    }

    public void burn(FuelTank fuelTank, Battery battery, float deltaTime) {
        float fuelToBurn = getFuelPerSecond() * deltaTime;
        float availableFuel = fuelTank.unfill(fuelToBurn);
        float multiplier = fuelToBurn / availableFuel;
        battery.charge(getEnergyPerSecond() * deltaTime * multiplier);
    }

    public float getEnergyPerSecond() {
        return upgrade.getEnergyPerSecond();
    }

    public float getFuelPerSecond() {
        return upgrade.getFuelPerSecond();
    }

    public float getOxygenPerSecond() {
        return upgrade.getOxygenPerSecond();
    }
}
