package com.pixelscientists.gdx.jam.machinery.ship;

/**
 * Fuel is used when using the thrusters. Upgrades: Less fuel consumption, faster movement, anti-thruster.
 *
 * @author Daniel Holderbaum
 */
public class Thruster {

    private float fuelConsumptionPerSecond;

    private float forcePerSecond;

    public float getFuelConsumptionPerSecond() {
        return fuelConsumptionPerSecond;
    }

    public float getForcePerSecond() {
        return forcePerSecond;
    }
}
