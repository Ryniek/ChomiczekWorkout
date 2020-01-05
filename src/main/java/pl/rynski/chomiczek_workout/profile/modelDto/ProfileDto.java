package pl.rynski.chomiczek_workout.profile.modelDto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

public class ProfileDto {
    @DecimalMin(value = "1.0", message = "Waga musi wynosić minimum 1kg oraz maximum 150kg.") @DecimalMax(value = "250.0", message = "Waga musi wynosić minimum 1kg oraz maximum 250kg.")
    private Double weight;
    @DecimalMin(value = "1.0", message = "Obwód klatki piersiowej musi wynosić minimum 1cm oraz maximum 150cm.") @DecimalMax(value = "150.0", message = "Obwód klatki piersiowej musi wynosić minimum 1cm oraz maximum 150cm.")
    private Double chestSize;
    @DecimalMin(value = "1.0", message = "Obwód ramienia musi wynosić minimum 1cm oraz maximum 80cm.") @DecimalMax(value = "80.0", message = "Obwód ramienia musi wynosić minimum 1cm oraz maximum 80cm.")
    private Double armSize;
    @DecimalMin(value = "1.0", message = "Obwód przedramienia musi wynosić minimum 1cm oraz maximum 50cm.") @DecimalMax(value = "50.0", message = "Obwód przedramienia musi wynosić minimum 1cm oraz maximum 50cm.")
    private Double forearmSize;
    @DecimalMin(value = "1.0", message = "Obwód uda musi wynosić minimum 1cm oraz maximum 100cm.") @DecimalMax(value = "100.0", message = "Obwód uda musi wynosić minimum 1cm oraz maximum 100cm.")
    private Double thighSize;
    @DecimalMin(value = "1.0", message = "Obwód łydki musi wynosić minimum 1cm oraz maximum 50cm.") @DecimalMax(value = "50.0", message = "Obwód łydki musi wynosić minimum 1cm oraz maximum 50cm.")
    private Double calfSize;
    private String lastUpdate;

    public ProfileDto() {
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getChestSize() {
        return chestSize;
    }

    public void setChestSize(Double chestSize) {
        this.chestSize = chestSize;
    }

    public Double getArmSize() {
        return armSize;
    }

    public void setArmSize(Double armSize) {
        this.armSize = armSize;
    }

    public Double getForearmSize() {
        return forearmSize;
    }

    public void setForearmSize(Double forearmSize) {
        this.forearmSize = forearmSize;
    }

    public Double getThighSize() {
        return thighSize;
    }

    public void setThighSize(Double thighSize) {
        this.thighSize = thighSize;
    }

    public Double getCalfSize() {
        return calfSize;
    }

    public void setCalfSize(Double calfSize) {
        this.calfSize = calfSize;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
