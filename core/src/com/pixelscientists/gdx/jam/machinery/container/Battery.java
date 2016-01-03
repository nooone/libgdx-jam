package com.pixelscientists.gdx.jam.machinery.container;

import com.pixelscientists.gdx.jam.machinery.BaseUpgradeable;
import com.pixelscientists.gdx.jam.machinery.Upgrade;
import com.pixelscientists.gdx.jam.machinery.Upgradeable;

/**
 * Stores energy. Upgrades can increase the maximum amount of energy stored.
 *
 * @author Daniel Holderbaum
 */
public class Battery implements Upgradeable<Battery.BatteryLevel> {

    public enum BatteryLevel implements Upgrade {
        BASE(300), UPGRADE_I(500), UPGRADE_II(1000);

        BatteryLevel(float maxEnergy) {
            this.maxEnergy = maxEnergy;
        }

        private final float maxEnergy;

        public float getMaxEnergy() {
            return maxEnergy;
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

    private BatteryLevel batteryLevel = BatteryLevel.BASE;

    private float energy = batteryLevel.maxEnergy;

    public boolean isEmpty() {
        return energy <= 0;
    }

    @Override
    public BatteryLevel getCurrentUpgrade() {
        return batteryLevel;
    }

    public void changeEnergy(float deltaEnergy) {
        energy += deltaEnergy;
    }

    public float getMaxEnergy() {
        return batteryLevel.getMaxEnergy();
    }

    public float getMissingEnergy() {
        return batteryLevel.getMaxEnergy() - energy;
    }

    public float getEnergy() {
        return energy;
    }
}
