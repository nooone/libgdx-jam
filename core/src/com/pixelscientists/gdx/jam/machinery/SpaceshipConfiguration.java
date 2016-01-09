package com.pixelscientists.gdx.jam.machinery;

/**
 * @author Daniel Holderbaum
 */
public class SpaceshipConfiguration {

    private boolean shieldEnabled;

    private boolean radarEnabled;

    private boolean burnOxygenEnabled;

    private boolean burnFuelEnabled;

    private boolean repairBotsEnabled;

    public boolean isRepairBotsEnabled() {
        return repairBotsEnabled;
    }

    public void setRepairBotsEnabled(boolean repairBotsEnabled) {
        this.repairBotsEnabled = repairBotsEnabled;
    }

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

    public boolean isBurnOxygenEnabled() {
        return burnOxygenEnabled;
    }

    public void setBurnOxygenEnabled(boolean burnOxygenEnabled) {
        this.burnOxygenEnabled = burnOxygenEnabled;
    }

    public boolean isBurnFuelEnabled() {
        return burnFuelEnabled;
    }

    public void setBurnFuelEnabled(boolean burnFuelEnabled) {
        this.burnFuelEnabled = burnFuelEnabled;
    }
}
