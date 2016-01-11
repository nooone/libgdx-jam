package com.pixelscientists.gdx.jam.machinery.generator;

import com.pixelscientists.gdx.jam.machinery.BaseUpgradeable;
import com.pixelscientists.gdx.jam.machinery.Upgrade;
import com.pixelscientists.gdx.jam.machinery.Upgradeable;

/**
 * Constantly generate a small amount of energy.
 *
 * @author Daniel Holderbaum
 */
public class SolarCells extends BaseUpgradeable<SolarCells.SolarCellsLevel> {

    public enum SolarCellsLevel implements Upgrade {
        NONE(0), BASE(300), UPGRADE_I(500), UPGRADE_II(1000);

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

    public SolarCells() {
        super(SolarCellsLevel.NONE);
    }

    public float getEnergyPerSecond() {
        return upgrade.getEnergyPerSecond();
    }
}
