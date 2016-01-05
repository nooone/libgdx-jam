package com.pixelscientists.gdx.jam.machinery.ship;

import com.pixelscientists.gdx.jam.machinery.BaseUpgradeable;
import com.pixelscientists.gdx.jam.machinery.Upgrade;
import com.pixelscientists.gdx.jam.machinery.Upgradeable;

/**
 * @author Daniel Holderbaum
 */
public class Radar implements Upgradeable<Radar.RadarLevel> {

    public enum RadarLevel implements Upgrade {
        BASE(300), UPGRADE_I(500), UPGRADE_II(1000);

        RadarLevel(float energyPerSecond) {
            this.energyPerSecond = energyPerSecond;
        }

        private final float energyPerSecond;

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

    private RadarLevel radarLevel = RadarLevel.BASE;

    @Override
    public RadarLevel getCurrentUpgrade() {
        return radarLevel;
    }

    public float getEnergyPerSecond() {
        return radarLevel.getEnergyPerSecond();
    }

}
