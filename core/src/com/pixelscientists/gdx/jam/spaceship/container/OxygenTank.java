package com.pixelscientists.gdx.jam.spaceship.container;

import com.pixelscientists.gdx.jam.spaceship.BaseUpgradeable;
import com.pixelscientists.gdx.jam.spaceship.Upgrade;

/**
 * Oxygen is constantly decreasing. It can be refilled at merchants or extracted from ice asteroids.
 *
 * @author Daniel Holderbaum
 */
public class OxygenTank extends BaseUpgradeable<OxygenTank.OxygenTankLevel> {

    public enum OxygenTankLevel implements Upgrade {
        NONE(0), BASE(300), UPGRADE_I(500), UPGRADE_II(1000);

        OxygenTankLevel(float maxOxygen) {
            this.maxOxygen = maxOxygen;
        }

        private final float maxOxygen;

        public float getMaxOxygen() {
            return maxOxygen;
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

    private float oxygen = upgrade.maxOxygen;

    public OxygenTank() {
        super(OxygenTankLevel.NONE);
    }

    public void fill(float newOxygen) {
        assert newOxygen >= 0;
        oxygen += newOxygen;
        oxygen = Math.min(oxygen, getMaxOxygen());
    }

    public float unfill(float wantedOxygen) {
        assert wantedOxygen >= 0;
        float returnedOxygen = Math.min(wantedOxygen, oxygen);
        oxygen -= returnedOxygen;
        return returnedOxygen;
    }

    public boolean isEmpty() {
        return oxygen <= 0;
    }

    public float getOxygen() {
        return oxygen;
    }

    public float getMissingOxygen() {
        return upgrade.maxOxygen - oxygen;
    }

    public float getMaxOxygen() {
        return upgrade.getMaxOxygen();
    }


}
