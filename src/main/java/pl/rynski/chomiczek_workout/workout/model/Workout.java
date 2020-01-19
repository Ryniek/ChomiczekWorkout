package pl.rynski.chomiczek_workout.workout.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<MuscleUp> muscleUpList = new ArrayList<>();
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<PullUp> pullUpList = new ArrayList<>();
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<Pump> pumpList = new ArrayList<>();
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<TrainingNote> notes = new ArrayList<>();;

    public Workout() {
    }

    public Workout(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<MuscleUp> getMuscleUpList() {
        return muscleUpList;
    }

    public void setMuscleUpList(List<MuscleUp> muscleUpList) {
        this.muscleUpList = muscleUpList;
    }

    public List<PullUp> getPullUpList() {
        return pullUpList;
    }

    public void setPullUpList(List<PullUp> pullUpList) {
        this.pullUpList = pullUpList;
    }

    public List<Pump> getPumpList() {
        return pumpList;
    }

    public void setPumpList(List<Pump> pumpList) {
        this.pumpList = pumpList;
    }

    public List<TrainingNote> getNotes() {
        return notes;
    }

    public void setNotes(List<TrainingNote> notes) {
        this.notes = notes;
    }
}
