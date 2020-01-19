package pl.rynski.chomiczek_workout.workout.trainings;

import pl.rynski.chomiczek_workout.workout.model.Workout;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Squad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @ManyToOne
    @JoinColumn
    private Workout workout;
    private LocalDate localDate;

    public Squad() {
    }

    public Squad(int quantity, Workout workout, LocalDate localDate) {
        this.quantity = quantity;
        this.workout = workout;
        this.localDate = localDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
