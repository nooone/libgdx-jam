package com.pixelscientists.gdx.jam.spaceship;

/**
 * @author Daniel Holderbaum
 */
public interface Upgradeable<T extends Upgrade> {

    T getCurrentUpgrade();

    void upgrade();

//    void downgrade();

}
