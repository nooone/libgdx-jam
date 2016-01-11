package com.pixelscientists.gdx.jam.machinery.weapon;

import com.pixelscientists.gdx.jam.machinery.BaseUpgradeable;
import com.pixelscientists.gdx.jam.machinery.Upgrade;
import com.pixelscientists.gdx.jam.machinery.Upgradeable;

/**
 * @author Daniel Holderbaum
 */
public class MineDropper extends BaseUpgradeable<MineDropper.MineDropperLevel> {

    public enum MineDropperLevel implements Upgrade {
        NONE(0), BASE(300), UPGRADE_I(500), UPGRADE_II(1000);

        MineDropperLevel(float energyPerShot) {
            this.energyPerShot = energyPerShot;
        }

        private final float energyPerShot;

        public float getEnergyPerShot() {
            return energyPerShot;
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

    public MineDropper() {
        super(MineDropperLevel.NONE);
    }

    public float getEnergyPerShot() {
        return upgrade.getEnergyPerShot();
    }
}
