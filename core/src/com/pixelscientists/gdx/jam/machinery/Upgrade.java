package com.pixelscientists.gdx.jam.machinery;

/**
 * @author Daniel Holderbaum
 */
public interface Upgrade {

    int getPrice();

    Upgrade getNext();
//    Upgrade getPrevious();

}
