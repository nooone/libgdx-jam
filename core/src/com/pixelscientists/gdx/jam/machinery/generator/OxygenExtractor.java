package com.pixelscientists.gdx.jam.machinery.generator;

import com.pixelscientists.gdx.jam.machinery.BaseUpgradeable;
import com.pixelscientists.gdx.jam.machinery.Upgrade;
import com.pixelscientists.gdx.jam.machinery.Upgradeable;

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
        public int getPrice() {
            return BaseUpgradeable.getPrice(this);
        }

        @Override
        public Upgrade getNext() {
            return BaseUpgradeable.getNext(this);
        }
    }

    private OxygenExtractorLevel oxygenExtractorLevel = OxygenExtractorLevel.BASE;

    @Override
    public OxygenExtractorLevel getCurrentUpgrade() {
        return oxygenExtractorLevel;
    }

    public float getOxygenPerSecond() {
        return oxygenExtractorLevel.getOxygenPerSecond();
    }

    public float getEnergyPerSecond() {
        return oxygenExtractorLevel.getEnergyPerSecond();
    }
}
