package com.pixelscientists.gdx.jam.machinery;

/**
 * @author Daniel Holderbaum
 */
public class SpaceshipConfiguration {

    private boolean shieldEnabled;

    private boolean radarEnabled;

    private boolean burnOxygen;

    private boolean burnFuel;

    public boolean isShieldEnabled() {
        return shieldEnabled;
    }

    public void setShieldEnabled(boolean shieldEnabled) {
        this.shieldEnabled = shieldEnabled;
    }

    public boolean isRadarEnabled() {
        return radarEnabled;
    }

    public void setRadarEnabled(boolean radarEnabled) {
        this.radarEnabled = radarEnabled;
    }

    public boolean isBurnOxygen() {
        return burnOxygen;
    }

    public void setBurnOxygen(boolean burnOxygen) {
        this.burnOxygen = burnOxygen;
    }

    public boolean isBurnFuel() {
        return burnFuel;
    }

    public void setBurnFuel(boolean burnFuel) {
        this.burnFuel = burnFuel;
    }
}
