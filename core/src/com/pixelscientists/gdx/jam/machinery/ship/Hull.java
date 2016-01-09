package com.pixelscientists.gdx.jam.machinery.ship;

import com.pixelscientists.gdx.jam.machinery.BaseUpgradeable;
import com.pixelscientists.gdx.jam.machinery.Upgrade;
import com.pixelscientists.gdx.jam.machinery.Upgradeable;

/**
 * Hull is the amount of health that a spaceship can have. If it breaks, the game is lost. It can be repaired using scrap-metal. Can be upgraded to take have higher health.
 *
 * @author Daniel Holderbaum
 */
public class Hull implements Upgradeable<Hull.HullLevel> {

    public enum HullLevel implements Upgrade {
        BASE(300), UPGRADE_I(500), UPGRADE_II(1000);

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

    private HullLevel hullLevel = HullLevel.BASE;
    private float health = hullLevel.getMaxHealth();

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
        return hullLevel.getMaxHealth();
    }

    public boolean isBroken() {
        return health <= 0f;
    }

    @Override
    public HullLevel getCurrentUpgrade() {
        return hullLevel;
    }
}
