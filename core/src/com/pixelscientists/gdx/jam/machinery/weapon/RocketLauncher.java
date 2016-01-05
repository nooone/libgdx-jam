package com.pixelscientists.gdx.jam.machinery.weapon;

import com.pixelscientists.gdx.jam.machinery.BaseUpgradeable;
import com.pixelscientists.gdx.jam.machinery.Upgrade;
import com.pixelscientists.gdx.jam.machinery.Upgradeable;

/**
 * A type of weapon that deals high damage on impact. Can be upgraded to target seeking rockets. Higher damage. Max amount of rockets.
 *
 * @author Daniel Holderbaum
 */
public class RocketLauncher implements Upgradeable<RocketLauncher.RocketLauncherLevel> {

    public enum RocketLauncherLevel implements Upgrade {
        BASE(300), UPGRADE_I(500), UPGRADE_II(1000);

        RocketLauncherLevel(float energyPerSecond) {
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

    private RocketLauncherLevel rocketLauncherLevel = RocketLauncherLevel.BASE;

    @Override
    public RocketLauncherLevel getCurrentUpgrade() {
        return rocketLauncherLevel;
    }

    public float getEnergyPerSecond() {
        return rocketLauncherLevel.getEnergyPerSecond();
    }
}
