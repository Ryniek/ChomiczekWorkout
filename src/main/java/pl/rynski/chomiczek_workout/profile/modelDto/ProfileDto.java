package pl.rynski.chomiczek_workout.profile.modelDto;

import java.time.LocalDateTime;

public class ProfileDto {
    private double weight;
    private double chestSize;
    private double armSize;
    private double forearmSize;
    private double thighSize;
    private double calfSize;
    private String lastUpdate;

    public ProfileDto() {
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getChestSize() {
        return chestSize;
    }

    public void setChestSize(double chestSize) {
        this.chestSize = chestSize;
    }

    public double getArmSize() {
        return armSize;
    }

    public void setArmSize(double armSize) {
        this.armSize = armSize;
    }

    public double getForearmSize() {
        return forearmSize;
    }

    public void setForearmSize(double forearmSize) {
        this.forearmSize = forearmSize;
    }

    public double getThighSize() {
        return thighSize;
    }

    public void setThighSize(double thighSize) {
        this.thighSize = thighSize;
    }

    public double getCalfSize() {
        return calfSize;
    }

    public void setCalfSize(double calfSize) {
        this.calfSize = calfSize;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
