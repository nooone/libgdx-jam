package com.pixelscientists.gdx.jam.machinery.generator;

import com.pixelscientists.gdx.jam.machinery.BaseUpgradeable;
import com.pixelscientists.gdx.jam.machinery.Upgrade;
import com.pixelscientists.gdx.jam.machinery.Upgradeable;

/**
 * Constantly generate a small amount of energy.
 *
 * @author Daniel Holderbaum
 */
public class SolarCells implements Upgradeable<SolarCells.SolarCellsLevel> {

    public enum SolarCellsLevel implements Upgrade {
        BASE(300), UPGRADE_I(500), UPGRADE_II(1000);

        SolarCellsLevel(float energyPerSecond) {
            this.energyPerSecond = energyPerSecond;
        }

        private float energyPerSecond;

        public float getEnergyPerSecond() {
            return energyPerSecond;
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

    private SolarCellsLevel solarCellsLevel = SolarCellsLevel.BASE;

    @Override
    public SolarCellsLevel getCurrentUpgrade() {
        return solarCellsLevel;
    }

    public float getEnergyPerSecond() {
        return solarCellsLevel.getEnergyPerSecond();
    }
}
