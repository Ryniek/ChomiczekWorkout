package pl.rynski.chomiczek_workout.workout.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

public class WorkoutDto {

    @DecimalMin(value = "0", message = "Liczba pompek musi wynosić minimum 1")
    private int pumpsQuantity;
    @DecimalMin(value = "0", message = "Liczba podciągnięć musi wynosić minimum 1")
    private int pullUpsQuantity;
    @DecimalMin(value = "0", message = "Liczba muscle upow musi wynosić minimum 1")
    private int muscleUpsQuantity;
    @Size(max = 500, message = "Maximum 500 znakow")
    private String note;

    public WorkoutDto() {
    }

    public WorkoutDto(int pumpsQuantity, int pullUpsQuantity, int muscleUpsQuantity, String note) {
        this.pumpsQuantity = pumpsQuantity;
        this.pullUpsQuantity = pullUpsQuantity;
        this.muscleUpsQuantity = muscleUpsQuantity;
        this.note = note;
    }

    public int getPumpsQuantity() {
        return pumpsQuantity;
    }

    public void setPumpsQuantity(int pumpsQuantity) {
        this.pumpsQuantity = pumpsQuantity;
    }

    public int getPullUpsQuantity() {
        return pullUpsQuantity;
    }

    public void setPullUpsQuantity(int pullUpsQuantity) {
        this.pullUpsQuantity = pullUpsQuantity;
    }

    public int getMuscleUpsQuantity() {
        return muscleUpsQuantity;
    }

    public void setMuscleUpsQuantity(int muscleUpsQuantity) {
        this.muscleUpsQuantity = muscleUpsQuantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
