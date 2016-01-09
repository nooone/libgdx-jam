package com.pixelscientists.gdx.jam.machinery.ship;

import com.pixelscientists.gdx.jam.machinery.BaseUpgradeable;
import com.pixelscientists.gdx.jam.machinery.Upgrade;
import com.pixelscientists.gdx.jam.machinery.Upgradeable;
import com.pixelscientists.gdx.jam.machinery.container.Battery;

/**
 * A shield recharges after taking damage. Recharging a shield costs energy. Upgrades make recharge faster.
 *
 * @author Daniel Holderbaum
 */
public class Shield implements Upgradeable<Shield.ShieldLevel> {

    public enum ShieldLevel implements Upgrade {
        BASE(300), UPGRADE_I(500), UPGRADE_II(1000);

        ShieldLevel(float maxShield) {
            this.maxShield = maxShield;
        }

        private float maxShield;
        private float shieldPerSecond;
        private float energyPerSecond;

        public float getMaxShield() {
            return maxShield;
        }

        public float getShieldPerSecond() {
            return shieldPerSecond;
        }

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

    private ShieldLevel shieldLevel = ShieldLevel.BASE;
    private float shield = shieldLevel.getMaxShield();

    @Override
    public ShieldLevel getCurrentUpgrade() {
        return shieldLevel;
    }

    public float damage(float damage) {
        float absorbedDamage = Math.min(shield, damage);
        shield -= absorbedDamage;
        return damage - absorbedDamage;
    }

    public void charge(Battery battery, float deltaTime) {
        float shieldToCharge = Math.min(getMissingShield(), getShieldPerSecond() * deltaTime);
        float neededEnergy = shieldToCharge / getS * getEnergyPerSecond();
        float battery.uncharge(neededEnergy);
        shield += shieldToCharge;
    }

    public float getShield() {
        return shield;
    }

    public float getMissingShield() {
        return getMaxShield() - shield;
    }

    public float getMaxShield() {
        return shieldLevel.getMaxShield();
    }

    public float getShieldPerSecond() {
        return shieldLevel.getShieldPerSecond();
    }

    public float getEnergyPerSecond() {
        return shieldLevel.getEnergyPerSecond();
    }
}
