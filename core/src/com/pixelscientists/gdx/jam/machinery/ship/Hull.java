package com.pixelscientists.gdx.jam.machinery.ship;

import com.pixelscientists.gdx.jam.machinery.BaseUpgradeable;
import com.pixelscientists.gdx.jam.machinery.Upgrade;
import com.pixelscientists.gdx.jam.machinery.Upgradeable;

/**
 * Hull is the amount of health that a spaceship can have. If it breaks, the game is lost. It can be repaired using scrap-metal. Can be upgraded to take have higher health.
 *
 * @author Daniel Holderbaum
 */
public class Hull extends BaseUpgradeable<Hull.HullLevel> {

    public enum HullLevel implements Upgrade {
        NONE(0), BASE(300), UPGRADE_I(500), UPGRADE_II(1000);

        HullLevel(float maxHealth) {
            this.maxHealth = maxHealth;
        }

        private final float maxHealth;

        public float getMaxHealth() {
            return maxHealth;
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

    private float health = upgrade.getMaxHealth();

    public Hull() {
        super(HullLevel.NONE);
    }

    public float getMissingHealth() {
        return getMaxHealth() - health;
    }

    public void repair(float reparation) {
        assert reparation >= 0;
        health += reparation;
        health = Math.min(health, getMaxHealth());
    }

    public void damage(float damage) {
        assert damage >= 0;
        health -= damage;
    }

    public float getHealth() {
        return health;
    }

    public float getMaxHealth() {
        return upgrade.getMaxHealth();
    }

    public boolean isBroken() {
        return health <= 0f;
    }
}
