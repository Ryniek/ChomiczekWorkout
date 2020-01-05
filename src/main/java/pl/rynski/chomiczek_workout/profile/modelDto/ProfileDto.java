package pl.rynski.chomiczek_workout.profile.modelDto;

import java.time.LocalDateTime;

public class ProfileDto {
    private double weight;
    @DecimalMin(value = "20.0", message = "Obwód klatki piersiowej musi wynosić minimum 1cm oraz maximum 150cm.") @DecimalMax(value = "20.0", message = "Obwód klatki piersiowej musi wynosić minimum 1cm oraz maximum 150cm.")
    private double chestSize;
    @DecimalMin(value = "80.0", message = "Obwód ramienia musi wynosić minimum 1cm oraz maximum 80cm.") @DecimalMax(value = "20.0", message = "Obwód ramienia musi wynosić minimum 1cm oraz maximum 80cm.")
    private double armSize;
    @DecimalMin(value = "80.0", message = "Obwód przed ramienia musi wynosić minimum 1cm oraz maximum 50cm.") @DecimalMax(value = "20.0", message = "Obwód przedramienia musi wynosić minimum 1cm oraz maximum 50cm.")
    private double forearmSize;
    @DecimalMin(value = "80.0", message = "Obwód uda musi wynosić minimum 1cm oraz maximum 100cm.") @DecimalMax(value = "20.0", message = "Obwód uda musi wynosić minimum 1cm oraz maximum 100cm.")
    private double thighSize;
    @DecimalMin(value = "80.0", message = "Obwód łydki musi wynosić minimum 1cm oraz maximum 50cm.") @DecimalMax(value = "20.0", message = "Obwód łydki musi wynosić minimum 1cm oraz maximum 50cm.")
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
