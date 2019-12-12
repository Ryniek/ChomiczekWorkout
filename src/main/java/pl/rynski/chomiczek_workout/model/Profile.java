package pl.rynski.chomiczek_workout.model;

import javax.persistence.*;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    private Double weight;
    private Double chestCircumference;
    private Double armCircumference;
    private Double forearmCircumference;
    private Double thighCircumference;
    private Double lowerLegCircumference;

    public Profile() {
    }

    public Profile(Long id, Long user_id, Double weight, Double chestCircumference, Double armCircumference, Double forearmCircumference, Double thighCircumference, Double lowerLegCircumference) {
        this.user_id = user_id;
        this.weight = weight;
        this.chestCircumference = chestCircumference;
        this.armCircumference = armCircumference;
        this.forearmCircumference = forearmCircumference;
        this.thighCircumference = thighCircumference;
        this.lowerLegCircumference = lowerLegCircumference;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getChestCircumference() {
        return chestCircumference;
    }

    public void setChestCircumference(Double chestCircumference) {
        this.chestCircumference = chestCircumference;
    }

    public Double getArmCircumference() {
        return armCircumference;
    }

    public void setArmCircumference(Double armCircumference) {
        this.armCircumference = armCircumference;
    }

    public Double getForearmCircumference() {
        return forearmCircumference;
    }

    public void setForearmCircumference(Double forearmCircumference) {
        this.forearmCircumference = forearmCircumference;
    }

    public Double getThighCircumference() {
        return thighCircumference;
    }

    public void setThighCircumference(Double thighCircumference) {
        this.thighCircumference = thighCircumference;
    }

    public Double getLowerLegCircumference() {
        return lowerLegCircumference;
    }

    public void setLowerLegCircumference(Double lowerLegCircumference) {
        this.lowerLegCircumference = lowerLegCircumference;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", weight=" + weight +
                ", chestCircumference=" + chestCircumference +
                ", armCircumference=" + armCircumference +
                ", forearmCircumference=" + forearmCircumference +
                ", thighCircumference=" + thighCircumference +
                ", lowerLegCircumference=" + lowerLegCircumference +
                '}';
    }
}
