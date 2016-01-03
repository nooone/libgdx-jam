package com.pixelscientists.gdx.jam.machinery.ship;

/**
 *
 *
 * @author Daniel Holderbaum
 */
public class Radar {

    public enum RadarUpgrade {
        BASE(300), UPGRADE_I(500), UPGRADE_II(1000);

        RadarUpgrade(float maxEnergy) {
            this.maxEnergy = maxEnergy;
        }

        private final float maxEnergy;

        public float getMaxEnergy() {
            return maxEnergy;
        }
    }

    private RadarUpgrade radarUpgrade = RadarUpgrade.BASE;
    private float energy = radarUpgrade.maxEnergy;

    public boolean isEmpty() {
        return energy <= 0;
    }

    public RadarUpgrade getRadarUpgrade() {
        return radarUpgrade;
    }

    public float getEnergy() {
        return energy;
    }

}
