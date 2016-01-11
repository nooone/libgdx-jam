package com.pixelscientists.gdx.jam.spaceship.ship;

import com.pixelscientists.gdx.jam.spaceship.BaseUpgradeable;
import com.pixelscientists.gdx.jam.spaceship.Upgrade;

/**
 * @author Daniel Holderbaum
 */
public class Radar extends BaseUpgradeable<Radar.RadarLevel> {

    public enum RadarLevel implements Upgrade {
        NONE(0), BASE(300), UPGRADE_I(500), UPGRADE_II(1000);

        RadarLevel(float energyPerSecond) {
            this.energyPerSecond = energyPerSecond;
        }

        private final float energyPerSecond;

        public float getEnergyPerSecond() {
            return energyPerSecond;
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

    public Radar() {
        super(RadarLevel.NONE);
    }

    public float getEnergyPerSecond() {
        return upgrade.getEnergyPerSecond();
    }

}
