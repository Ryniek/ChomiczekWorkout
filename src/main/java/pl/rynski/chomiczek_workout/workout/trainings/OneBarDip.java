package pl.rynski.chomiczek_workout.workout.trainings;

import pl.rynski.chomiczek_workout.workout.model.Workout;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class OneBarDip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @ManyToOne
    @JoinColumn
    private Workout workout;
    private LocalDate localDate;

    public OneBarDip() {
    }

    public OneBarDip(int quantity, Workout workout, LocalDate localDate) {
        this.quantity = quantity;
        this.workout = workout;
        this.localDate = localDate;
    }
}
