package com.pixelscientists.gdx.jam.machinery.generator;

import com.pixelscientists.gdx.jam.machinery.BaseUpgradeable;
import com.pixelscientists.gdx.jam.machinery.Upgrade;
import com.pixelscientists.gdx.jam.machinery.Upgradeable;
import com.pixelscientists.gdx.jam.machinery.container.Battery;
import com.pixelscientists.gdx.jam.machinery.ship.Hull;

/**
 * @author Daniel Holderbaum
 */
public class RepairBots extends BaseUpgradeable<RepairBots.RepairBotsLevel> {

    public enum RepairBotsLevel implements Upgrade {
        NONE(0, 100), BASE(300, 100), UPGRADE_I(500, 100), UPGRADE_II(1000, 100);

        RepairBotsLevel(float repairPerSecond, float energyPerSecond) {
            this.repairPerSecond = repairPerSecond;
            this.energyPerSecond = energyPerSecond;
        }

        private float repairPerSecond;
        private float energyPerSecond;

        public float getEnergyPerSecond() {
            return energyPerSecond;
        }

        public float getRepairPerSecond() {
            return repairPerSecond;
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

    private RepairBotsLevel repairBotsLevel = RepairBotsLevel.BASE;

    public void repair(Battery battery, Hull hull, float deltaTime) {
//        float repairingTime = Math.min(deltaTime, hull.getMissingHealth() / getRepairPerSecond());
//        float amountToRepair = Math.min(hull.getMissingHealth(), deltaTime * getRepairPerSecond());
        float neededEnergy = deltaTime * getEnergyPerSecond();
        float availableEnergy = battery.uncharge(neededEnergy);
        float multiplier = availableEnergy / neededEnergy;
        hull.repair(getRepairPerSecond() * deltaTime * multiplier);
    }

    @Override
    public RepairBotsLevel getCurrentUpgrade() {
        return repairBotsLevel;
    }

    public float getRepairPerSecond() {
        return repairBotsLevel.getRepairPerSecond();
    }

    public float getEnergyPerSecond() {
        return repairBotsLevel.getEnergyPerSecond();
    }
}
