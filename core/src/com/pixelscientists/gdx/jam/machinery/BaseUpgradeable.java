package com.pixelscientists.gdx.jam.machinery;

/**
 * @author Daniel Holderbaum
 */
public abstract class BaseUpgradeable {

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
                return 100;
            case 1:
                return 200;
            case 2:
                return 300;
            default:
                throw new RuntimeException("Could not determine price for " + upgrade);
        }
    }

}
