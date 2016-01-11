package com.pixelscientists.gdx.jam.spaceship;

/**
 * @author Daniel Holderbaum
 */
public abstract class BaseUpgradeable<T extends Upgrade> implements Upgradeable<T> {

    protected T upgrade;

    public BaseUpgradeable(T upgrade) {
        this.upgrade = upgrade;
    }

    @Override
    public T getCurrentUpgrade() {
        return upgrade;
    }

    @Override
    public void upgrade() {
        upgrade = (T) upgrade.getNext();
    }

    public static <E extends Enum<E>> E getPrevious(Enum<E> upgrade) {
        int index = upgrade.ordinal();
        if (index > 0) {
            return upgrade.getDeclaringClass().getEnumConstants()[index - 1];
        } else {
            return null;
        }
    }

    public static <E extends Enum<E>> E getNext(Enum<E> upgrade) {
        int index = upgrade.ordinal();
        if (index < upgrade.getDeclaringClass().getEnumConstants().length) {
            return upgrade.getDeclaringClass().getEnumConstants()[index + 1];
        } else {
            return null;
        }
    }

    public static <E extends Enum<E>> int getPrice(Enum<E> upgrade) {
        switch (upgrade.ordinal()) {
            case 0:
                return 0;
            case 1:
                return 100;
            case 2:
                return 200;
            case 3:
                return 300;
            default:
                throw new RuntimeException("Could not determine price for " + upgrade);
        }
    }

}
