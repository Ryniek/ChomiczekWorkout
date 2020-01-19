package pl.rynski.chomiczek_workout.workout.model;

import java.time.LocalDate;

public class WorkoutDto {

    private int pumpsQuantity;
    private int pullUpsQuantity;
    private int muscleUpsQuantity;
    
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
