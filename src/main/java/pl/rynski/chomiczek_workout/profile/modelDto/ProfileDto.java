package pl.rynski.chomiczek_workout.profile.modelDto;

public class ProfileDto {
    private double weight;
    private double chestSize;
    private double armSize;
    private double forearmSize;
    private double thighSize;
    private double calfSize;

    public ProfileDto() {
    }

    public ProfileDto(double weight, double chestSize, double armSize, double forearmSize, double thighSize, double calfSize) {
        this.weight = weight;
        this.chestSize = chestSize;
        this.armSize = armSize;
        this.forearmSize = forearmSize;
        this.thighSize = thighSize;
        this.calfSize = calfSize;
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
}
