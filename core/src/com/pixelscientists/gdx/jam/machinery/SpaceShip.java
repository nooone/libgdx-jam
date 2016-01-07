package com.pixelscientists.gdx.jam.machinery;

import com.pixelscientists.gdx.jam.machinery.container.BankAccount;
import com.pixelscientists.gdx.jam.machinery.container.Battery;
import com.pixelscientists.gdx.jam.machinery.container.FuelTank;
import com.pixelscientists.gdx.jam.machinery.container.OxygenTank;
import com.pixelscientists.gdx.jam.machinery.generator.Generator;
import com.pixelscientists.gdx.jam.machinery.generator.OxygenExtractor;
import com.pixelscientists.gdx.jam.machinery.generator.SolarCells;
import com.pixelscientists.gdx.jam.machinery.ship.Hull;
import com.pixelscientists.gdx.jam.machinery.ship.Shield;
import com.pixelscientists.gdx.jam.machinery.ship.Thruster;
import com.pixelscientists.gdx.jam.machinery.weapon.Cannon;
import com.pixelscientists.gdx.jam.machinery.weapon.MineDropper;
import com.pixelscientists.gdx.jam.machinery.weapon.RocketLauncher;

/**
 * @author Daniel Holderbaum
 */
public class Spaceship {

    protected Battery battery;
    protected FuelTank fuelTank;
    protected OxygenTank oxygenTank;
    protected BankAccount bankAccount;

    protected Hull hull;
    protected Shield shield;
    protected Thruster thruster;

    protected Cannon cannon;
    protected MineDropper mineDropper;
    protected RocketLauncher rocketLauncher;

    protected OxygenExtractor oxygenExtractor;
    protected SolarCells solarCells;
    protected Generator generator;

    protected SpaceshipConfiguration spaceshipConfiguration;

    public void takeDamage(float damage) {
//        shield.c
    }

    public void update(float deltaTime) {
        if (spaceshipConfiguration.isShieldEnabled()) {
            shield.charge(battery, deltaTime);
        }
    }

    public Battery getBattery() {
        return battery;
    }

    public FuelTank getFuelTank() {
        return fuelTank;
    }

    public OxygenTank getOxygenTank() {
        return oxygenTank;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public Hull getHull() {
        return hull;
    }

    public Shield getShield() {
        return shield;
    }

    public Thruster getThruster() {
        return thruster;
    }

    public Cannon getCannon() {
        return cannon;
    }

    public MineDropper getMineDropper() {
        return mineDropper;
    }

    public RocketLauncher getRocketLauncher() {
        return rocketLauncher;
    }

    public OxygenExtractor getOxygenExtractor() {
        return oxygenExtractor;
    }

    public SolarCells getSolarCells() {
        return solarCells;
    }

    public Generator getGenerator() {
        return generator;
    }
}
