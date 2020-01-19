package pl.rynski.chomiczek_workout.workout.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class TrainingNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne
    @JoinColumn
    private Workout workout;

    public TrainingNote() {
    }

    public TrainingNote(String content, Workout workout) {
        this.content = content;
        this.workout = workout;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }
}
