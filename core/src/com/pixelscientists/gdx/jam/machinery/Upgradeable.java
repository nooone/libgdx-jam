package com.pixelscientists.gdx.jam.machinery;

/**
 * @author Daniel Holderbaum
 */
public interface Upgradeable<T extends Upgrade> {

    T getCurrentUpgrade();

}
