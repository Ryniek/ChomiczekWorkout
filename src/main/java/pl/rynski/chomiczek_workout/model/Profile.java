package pl.rynski.chomiczek_workout.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    private Map<LocalDateTime, Double> weight;
    private Map<LocalDateTime, Double> chestCircumference;
    private Map<LocalDateTime, Double> armCircumference;
    private Map<LocalDateTime, Double> forearmCircumference;
    private Map<LocalDateTime, Double> thighCircumference;
    private Map<LocalDateTime, Double> lowerLegCircumference;

    public Profile() {
        weight = new HashMap<>();
        chestCircumference = new HashMap<>();
        armCircumference = new HashMap<>();
        forearmCircumference = new HashMap<>();
        thighCircumference = new HashMap<>();
        lowerLegCircumference = new HashMap<>();
    }

    public Double getWeight(LocalDateTime date) {
        return weight.get(date);
    }

    public void setWeight(LocalDateTime date, Double weight) {
        this.weight.put(date, weight);
    }
    public Double getChestCircumference(LocalDateTime date) {
        return chestCircumference.get(date);
    }

    public void setChestCircumference(LocalDateTime date, Double circ) {
        chestCircumference.put(date, circ);
    }

    public Double getArmCircumference(LocalDateTime date) {
        return armCircumference.get(date);
    }

    public void setArmCircumference(LocalDateTime date, Double circ) {
        armCircumference.put(date, circ);
    }

    public Double getForearmCircumference(LocalDateTime date) {
        return forearmCircumference.get(date);
    }

    public void setForearmCircumference(LocalDateTime date, Double circ) {
        forearmCircumference.put(date, circ);
    }
    public Double getThighCircumference(LocalDateTime date) {
        return thighCircumference.get(date);
    }

    public void setThighCircumference(LocalDateTime date, Double circ) {
        thighCircumference.put(date, circ);
    }
    public Double getLowerLegCircumference(LocalDateTime date) {
        return lowerLegCircumference.get(date);
    }

    public void setLowerLegCircumference(LocalDateTime date, Double circ) {
        lowerLegCircumference.put(date, circ);
    }



}
