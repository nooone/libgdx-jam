package com.pixelscientists.gdx.jam.machinery.container;

import com.badlogic.gdx.math.MathUtils;
import com.pixelscientists.gdx.jam.machinery.BaseUpgradeable;
import com.pixelscientists.gdx.jam.machinery.Upgrade;
import com.pixelscientists.gdx.jam.machinery.Upgradeable;

/**
 * Stores energy. Upgrades can increase the maximum amount of energy stored.
 *
 * @author Daniel Holderbaum
 */
public class Battery extends BaseUpgradeable<Battery.BatteryLevel> {

    public enum BatteryLevel implements Upgrade {
        NONE(0), BASE(300), UPGRADE_I(500), UPGRADE_II(1000);

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

    private float energy = upgrade.maxEnergy;

    public Battery() {
        super(BatteryLevel.NONE);
    }

    public boolean isEmpty() {
        return energy <= 0;
    }

    public void charge(float newEnergy) {
        assert newEnergy >= 0;
        energy += newEnergy;
        energy = Math.min(energy, getMaxEnergy());
    }

    public float uncharge(float wantedEnergy) {
        assert wantedEnergy >= 0;
        float returnedEnergy = Math.min(wantedEnergy, energy);
        energy -= returnedEnergy;
        return returnedEnergy;
    }

    public float getMaxEnergy() {
        return upgrade.getMaxEnergy();
    }

    public float getMissingEnergy() {
        return upgrade.getMaxEnergy() - energy;
    }

    public float getEnergy() {
        return energy;
    }
}
