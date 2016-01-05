package com.pixelscientists.gdx.jam.machinery.generator;

import com.pixelscientists.gdx.jam.machinery.BaseUpgradeable;
import com.pixelscientists.gdx.jam.machinery.Upgrade;
import com.pixelscientists.gdx.jam.machinery.Upgradeable;

/**
 * @author Daniel Holderbaum
 */
public class Generator implements Upgradeable<Generator.GeneratorLevel> {

    public enum GeneratorLevel implements Upgrade {
        BASE(300, 100, 100), UPGRADE_I(500, 100, 100), UPGRADE_II(1000, 100, 100);

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
        public int getPrice() {
            return BaseUpgradeable.getPrice(this);
        }

        @Override
        public Upgrade getNext() {
            return BaseUpgradeable.getNext(this);
        }
    }

    private GeneratorLevel generatorLevel = GeneratorLevel.BASE;

    @Override
    public GeneratorLevel getCurrentUpgrade() {
        return generatorLevel;
    }

    public float getEnergyPerSecond() {
        return generatorLevel.getEnergyPerSecond();
    }

    public float getFuelPerSecond() {
        return generatorLevel.getFuelPerSecond();
    }
}
