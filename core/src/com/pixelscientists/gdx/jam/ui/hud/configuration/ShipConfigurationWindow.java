package com.pixelscientists.gdx.jam.ui.hud.configuration;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.pixelscientists.gdx.jam.machinery.Spaceship;
import com.pixelscientists.gdx.jam.machinery.SpaceshipConfiguration;

/**
 * @author Daniel Holderbaum
 */
public class ShipConfigurationWindow extends Window {

    private Spaceship spaceship;

    public ShipConfigurationWindow(Spaceship spaceship, Skin skin) {
        super("Ship Configuration", skin);

        add("Generator (Fuel): ").left();
        ToggleBurnFuelButton toggleBurnFuelButton = new ToggleBurnFuelButton(skin, spaceship);
        add(toggleBurnFuelButton);
        row();

        add("Generator (Oxygen): ").left();
        ToggleBurnOxygenButton toggleBurnOxygenButton = new ToggleBurnOxygenButton(skin, spaceship);
        add(toggleBurnOxygenButton);
        row();

        add("Radar: ").left();
        ToggleRadarButton toggleRadarButton = new ToggleRadarButton(skin, spaceship);
        add(toggleRadarButton);
        row();

        add("Repair Bots: ").left();
        ToggleRepairBotsButton toggleRepairBotsButton = new ToggleRepairBotsButton(skin, spaceship);
        add(toggleRepairBotsButton);
        row();

        add("Shield: ").left();
        ToggleShieldButton toggleShieldButton = new ToggleShieldButton(skin, spaceship);
        add(toggleShieldButton);
        row();
    }
}
