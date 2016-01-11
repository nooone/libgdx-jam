package com.pixelscientists.gdx.jam.spaceship;

import com.badlogic.gdx.utils.Array;
import com.pixelscientists.gdx.jam.spaceship.container.BankAccount;
import com.pixelscientists.gdx.jam.spaceship.container.Battery;
import com.pixelscientists.gdx.jam.spaceship.container.FuelTank;
import com.pixelscientists.gdx.jam.spaceship.container.OxygenTank;
import com.pixelscientists.gdx.jam.spaceship.generator.Generator;
import com.pixelscientists.gdx.jam.spaceship.generator.OxygenExtractor;
import com.pixelscientists.gdx.jam.spaceship.generator.RepairBots;
import com.pixelscientists.gdx.jam.spaceship.generator.SolarCells;
import com.pixelscientists.gdx.jam.spaceship.ship.Hull;
import com.pixelscientists.gdx.jam.spaceship.ship.Shield;
import com.pixelscientists.gdx.jam.spaceship.ship.Thruster;
import com.pixelscientists.gdx.jam.spaceship.weapon.Cannon;
import com.pixelscientists.gdx.jam.spaceship.weapon.MineDropper;
import com.pixelscientists.gdx.jam.spaceship.weapon.RocketLauncher;

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
    protected RepairBots repairBots;

    protected SpaceshipConfiguration spaceshipConfiguration;

    public Spaceship() {
        battery = new Battery();
        fuelTank = new FuelTank();
        oxygenTank = new OxygenTank();
        bankAccount = new BankAccount();

        hull = new Hull();
        shield = new Shield();
        thruster = new Thruster();

        cannon = new Cannon();
        mineDropper = new MineDropper();
        rocketLauncher = new RocketLauncher();

        oxygenExtractor = new OxygenExtractor();
        solarCells = new SolarCells();
        generator = new Generator();
        repairBots = new RepairBots();

        spaceshipConfiguration = new SpaceshipConfiguration();
    }

    public Array<Upgradeable> getUpgradeables() {
        Array<Upgradeable> upgradeables = new Array<>();

        upgradeables.add(battery);
        upgradeables.add(fuelTank);
        upgradeables.add(oxygenTank);

        upgradeables.add(hull);
        upgradeables.add(shield);
        upgradeables.add(thruster);

        upgradeables.add(cannon);
        upgradeables.add(mineDropper);
        upgradeables.add(rocketLauncher);

        upgradeables.add(oxygenExtractor);
        upgradeables.add(solarCells);
        upgradeables.add(generator);
        upgradeables.add(repairBots);

        return upgradeables;
    }

    public void takeDamage(float damage) {
        float nonAbsorbedDamage = shield.damage(damage);
        hull.damage(nonAbsorbedDamage);
    }

    public void update(float deltaTime) {
        if (spaceshipConfiguration.isShieldEnabled()) {
            shield.charge(battery, deltaTime);
        }
        if (spaceshipConfiguration.isBurnFuelEnabled()) {
            generator.burn(fuelTank, battery, deltaTime);
        }
        if (spaceshipConfiguration.isBurnOxygenEnabled()) {
            generator.burn(oxygenTank, battery, deltaTime);
        }
        if (spaceshipConfiguration.isRepairBotsEnabled()) {
            repairBots.repair(battery, hull, deltaTime);
        }
    }

    public SpaceshipConfiguration getSpaceshipConfiguration() {
        return spaceshipConfiguration;
    }

    public RepairBots getRepairBots() {
        return repairBots;
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
