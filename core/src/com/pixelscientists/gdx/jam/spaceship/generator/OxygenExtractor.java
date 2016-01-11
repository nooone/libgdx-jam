package com.pixelscientists.gdx.jam.spaceship.generator;

import com.pixelscientists.gdx.jam.spaceship.BaseUpgradeable;
import com.pixelscientists.gdx.jam.spaceship.Upgrade;

/**
 * Uses energy to extract oxygen from ice asteroids.
 *
 * @author Daniel Holderbaum
 */
public class OxygenExtractor extends BaseUpgradeable<OxygenExtractor.OxygenExtractorLevel> {

    public enum OxygenExtractorLevel implements Upgrade {
        NONE(0, 100), BASE(300, 100), UPGRADE_I(500, 100), UPGRADE_II(1000, 100);

        OxygenExtractorLevel(float oxygenPerSecond, float energyPerSecond) {
            this.oxygenPerSecond = oxygenPerSecond;
            this.energyPerSecond = energyPerSecond;
        }

        private float oxygenPerSecond;
        private float energyPerSecond;

        public float getEnergyPerSecond() {
            return energyPerSecond;
        }

        public float getOxygenPerSecond() {
            return oxygenPerSecond;
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

    public OxygenExtractor() {
        super(OxygenExtractorLevel.NONE);
    }

    public float getOxygenPerSecond() {
        return upgrade.getOxygenPerSecond();
    }

    public float getEnergyPerSecond() {
        return upgrade.getEnergyPerSecond();
    }
}
