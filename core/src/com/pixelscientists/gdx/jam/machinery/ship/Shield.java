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
public class Shield extends BaseUpgradeable<Shield.ShieldLevel> {

    public enum ShieldLevel implements Upgrade {
        NONE(0), BASE(300), UPGRADE_I(500), UPGRADE_II(1000);

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

    private float shield = upgrade.getMaxShield();

    public Shield() {
        super(ShieldLevel.NONE);
    }

    public float damage(float damage) {
        float absorbedDamage = Math.min(shield, damage);
        shield -= absorbedDamage;
        return damage - absorbedDamage;
    }

    public void charge(Battery battery, float deltaTime) {
//        float shieldToCharge = Math.min(getMissingShield(), getShieldPerSecond() * deltaTime);
        float shieldToCharge = getShieldPerSecond() * deltaTime;
        float neededEnergy = getEnergyPerSecond() * deltaTime;
        float availableEnergy = battery.uncharge(neededEnergy);
        float multiplier = availableEnergy / neededEnergy;
        shield += shieldToCharge * multiplier;
    }

    public float getShield() {
        return shield;
    }

    public float getMissingShield() {
        return getMaxShield() - shield;
    }

    public float getMaxShield() {
        return upgrade.getMaxShield();
    }

    public float getShieldPerSecond() {
        return upgrade.getShieldPerSecond();
    }

    public float getEnergyPerSecond() {
        return upgrade.getEnergyPerSecond();
    }
}
