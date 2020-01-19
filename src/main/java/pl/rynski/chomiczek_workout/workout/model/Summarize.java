package pl.rynski.chomiczek_workout.workout.model;

public class Summarize {

    private boolean isPump;
    private boolean isPullUp;
    private boolean isMuscleUp;

    public Summarize() {
    }

    public boolean isPump() {
        return isPump;
    }

    public void setPump(boolean pump) {
        isPump = pump;
    }

    public boolean isPullUp() {
        return isPullUp;
    }

    public void setPullUp(boolean pullUp) {
        isPullUp = pullUp;
    }

    public boolean isMuscleUp() {
        return isMuscleUp;
    }

    public void setMuscleUp(boolean muscleUp) {
        isMuscleUp = muscleUp;
    }
}
