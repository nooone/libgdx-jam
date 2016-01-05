package com.pixelscientists.gdx.jam.machinery.weapon;

import com.pixelscientists.gdx.jam.machinery.BaseUpgradeable;
import com.pixelscientists.gdx.jam.machinery.Upgrade;
import com.pixelscientists.gdx.jam.machinery.Upgradeable;

/**
 * @author Daniel Holderbaum
 */
public class MineDropper implements Upgradeable<MineDropper.MineDropperLevel> {

    public enum MineDropperLevel implements Upgrade {
        BASE(300), UPGRADE_I(500), UPGRADE_II(1000);

        MineDropperLevel(float energyPerSecond) {
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

    private MineDropperLevel mineDropperLevel = MineDropperLevel.BASE;

    @Override
    public MineDropperLevel getCurrentUpgrade() {
        return mineDropperLevel;
    }

    public float getEnergyPerSecond() {
        return mineDropperLevel.getEnergyPerSecond();
    }
}
