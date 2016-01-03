package com.pixelscientists.gdx.jam.machinery.container;

import com.badlogic.gdx.math.MathUtils;
import com.pixelscientists.gdx.jam.machinery.BaseUpgradeable;
import com.pixelscientists.gdx.jam.machinery.Upgrade;
import com.pixelscientists.gdx.jam.machinery.Upgradeable;

/**
 * Oxygen is constantly decreasing. It can be refilled at merchants or extracted from ice asteroids.
 *
 * @author Daniel Holderbaum
 */
public class OxygenTank implements Upgradeable<OxygenTank.OxygenTankLevel> {

    public enum OxygenTankLevel implements Upgrade {
        BASE(300), UPGRADE_I(500), UPGRADE_II(1000);

        OxygenTankLevel(float maxOxygen) {
            this.maxOxygen = maxOxygen;
        }

        private final float maxOxygen;

        public float getMaxOxygen() {
            return maxOxygen;
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

    private OxygenTankLevel oxygenTankLevel = OxygenTankLevel.BASE;
    private float oxygen = oxygenTankLevel.maxOxygen;

    public boolean isEmpty() {
        return oxygen <= 0;
    }

    public float getOxygen() {
        return oxygen;
    }

    public float getMissingOxygen() {
        return oxygenTankLevel.maxOxygen - oxygen;
    }

    public void changeOxygen(float oxygen) {
        this.oxygen += oxygen;
    }

    public float getMaxOxygen() {
        return oxygenTankLevel.getMaxOxygen();
    }

    @Override
    public OxygenTankLevel getCurrentUpgrade() {
        return oxygenTankLevel;
    }

}
