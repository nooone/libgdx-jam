package com.pixelscientists.gdx.jam.machinery.weapon;

import com.pixelscientists.gdx.jam.machinery.BaseUpgradeable;
import com.pixelscientists.gdx.jam.machinery.Upgrade;
import com.pixelscientists.gdx.jam.machinery.Upgradeable;

/**
 * A type of weapon that deals high damage on impact. Can be upgraded to target seeking rockets. Higher damage. Max amount of rockets.
 *
 * @author Daniel Holderbaum
 */
public class RocketLauncher extends BaseUpgradeable<RocketLauncher.RocketLauncherLevel> {

    public enum RocketLauncherLevel implements Upgrade {
        NONE(0, 0), BASE(10, 150), UPGRADE_I(10, 250), UPGRADE_II(10, 500);

        RocketLauncherLevel(float fuelPerShot, float damage) {
            this.fuelPerShot = fuelPerShot;
            this.damage = damage;
        }

        private final float fuelPerShot;
        private final float damage;

        public float getFuelPerShot() {
            return fuelPerShot;
        }

        public float getDamage() {
            return damage;
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

    public RocketLauncher() {
        super(RocketLauncherLevel.NONE);
    }

    public float getFuelPerShot() {
        return upgrade.getFuelPerShot();
    }

    public float getDamage() {
        return upgrade.getDamage();
    }
}
