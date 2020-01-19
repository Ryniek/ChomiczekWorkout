package pl.rynski.chomiczek_workout.workout.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

public class WorkoutDto {

    @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1")
    private int pumpsQuantity;
    @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1")
    private int pullUpsQuantity;
    @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1")
    private int muscleUpsQuantity;
    @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1")
    private int australianPullUpsQuantity;
    @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1")
    private int diamondPushupsQuantity;
    @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1")
    private int dipsQuantity;
    @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1")
    private int impossibleDipsQuantity;
    @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1")
    private int oneBarDipsQuantity;
    @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1")
    private int planchePushupsQuantity;
    @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1")
    private int pullUpsUnderQuantity;
    @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1")
    private int skinTheCatQuantity;
    @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1")
    private int squadsQuantity;
    @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1")
    private int tigerPushupsQuantity;
    @Size(max = 500, message = "Maximum 500 znakow")
    private String note;

    public WorkoutDto() {
    }

    public WorkoutDto(@DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1") int pumpsQuantity, @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1") int pullUpsQuantity, @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1") int muscleUpsQuantity, @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1") int australianPullUpsQuantity, @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1") int diamondPushupsQuantity, @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1") int dipsQuantity, @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1") int impossibleDipsQuantity, @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1") int oneBarDipsQuantity, @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1") int planchePushupsQuantity, @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1") int pullUpsUnderQuantity, @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1") int skinTheCatQuantity, @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1") int squadsQuantity, @DecimalMin(value = "0", message = "Liczba powtórzeń musi wynosić conajmniej 1") int tigerPushupsQuantity, @Size(max = 500, message = "Maximum 500 znakow") String note) {
        this.pumpsQuantity = pumpsQuantity;
        this.pullUpsQuantity = pullUpsQuantity;
        this.muscleUpsQuantity = muscleUpsQuantity;
        this.australianPullUpsQuantity = australianPullUpsQuantity;
        this.diamondPushupsQuantity = diamondPushupsQuantity;
        this.dipsQuantity = dipsQuantity;
        this.impossibleDipsQuantity = impossibleDipsQuantity;
        this.oneBarDipsQuantity = oneBarDipsQuantity;
        this.planchePushupsQuantity = planchePushupsQuantity;
        this.pullUpsUnderQuantity = pullUpsUnderQuantity;
        this.skinTheCatQuantity = skinTheCatQuantity;
        this.squadsQuantity = squadsQuantity;
        this.tigerPushupsQuantity = tigerPushupsQuantity;
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

    public int getAustralianPullUpsQuantity() {
        return australianPullUpsQuantity;
    }

    public void setAustralianPullUpsQuantity(int australianPullUpsQuantity) {
        this.australianPullUpsQuantity = australianPullUpsQuantity;
    }

    public int getDiamondPushupsQuantity() {
        return diamondPushupsQuantity;
    }

    public void setDiamondPushupsQuantity(int diamondPushupsQuantity) {
        this.diamondPushupsQuantity = diamondPushupsQuantity;
    }

    public int getDipsQuantity() {
        return dipsQuantity;
    }

    public void setDipsQuantity(int dipsQuantity) {
        this.dipsQuantity = dipsQuantity;
    }

    public int getImpossibleDipsQuantity() {
        return impossibleDipsQuantity;
    }

    public void setImpossibleDipsQuantity(int impossibleDipsQuantity) {
        this.impossibleDipsQuantity = impossibleDipsQuantity;
    }

    public int getOneBarDipsQuantity() {
        return oneBarDipsQuantity;
    }

    public void setOneBarDipsQuantity(int oneBarDipsQuantity) {
        this.oneBarDipsQuantity = oneBarDipsQuantity;
    }

    public int getPlanchePushupsQuantity() {
        return planchePushupsQuantity;
    }

    public void setPlanchePushupsQuantity(int planchePushupsQuantity) {
        this.planchePushupsQuantity = planchePushupsQuantity;
    }

    public int getPullUpsUnderQuantity() {
        return pullUpsUnderQuantity;
    }

    public void setPullUpsUnderQuantity(int pullUpsUnderQuantity) {
        this.pullUpsUnderQuantity = pullUpsUnderQuantity;
    }

    public int getSkinTheCatQuantity() {
        return skinTheCatQuantity;
    }

    public void setSkinTheCatQuantity(int skinTheCatQuantity) {
        this.skinTheCatQuantity = skinTheCatQuantity;
    }

    public int getSquadsQuantity() {
        return squadsQuantity;
    }

    public void setSquadsQuantity(int squadsQuantity) {
        this.squadsQuantity = squadsQuantity;
    }

    public int getTigerPushupsQuantity() {
        return tigerPushupsQuantity;
    }

    public void setTigerPushupsQuantity(int tigerPushupsQuantity) {
        this.tigerPushupsQuantity = tigerPushupsQuantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
