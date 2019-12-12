package pl.rynski.chomiczek_workout.model;

import javax.persistence.*;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    private Parameter weight;
    private Parameter chestCircumference;
    private Parameter armCircumference;
    private Parameter forearmCircumference;
    private Parameter thighCircumference;
    private Parameter lowerLegCircumference;

    public Profile() {
    }

    public Profile(Long user_id, Parameter weight, Parameter chestCircumference, Parameter armCircumference, Parameter forearmCircumference, Parameter thighCircumference, Parameter lowerLegCircumference) {
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

    public Parameter getWeight() {
        return weight;
    }

    public void setWeight(Parameter weight) {
        this.weight = weight;
    }

    public Parameter getChestCircumference() {
        return chestCircumference;
    }

    public void setChestCircumference(Parameter chestCircumference) {
        this.chestCircumference = chestCircumference;
    }

    public Parameter getArmCircumference() {
        return armCircumference;
    }

    public void setArmCircumference(Parameter armCircumference) {
        this.armCircumference = armCircumference;
    }

    public Parameter getForearmCircumference() {
        return forearmCircumference;
    }

    public void setForearmCircumference(Parameter forearmCircumference) {
        this.forearmCircumference = forearmCircumference;
    }

    public Parameter getThighCircumference() {
        return thighCircumference;
    }

    public void setThighCircumference(Parameter thighCircumference) {
        this.thighCircumference = thighCircumference;
    }

    public Parameter getLowerLegCircumference() {
        return lowerLegCircumference;
    }

    public void setLowerLegCircumference(Parameter lowerLegCircumference) {
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
