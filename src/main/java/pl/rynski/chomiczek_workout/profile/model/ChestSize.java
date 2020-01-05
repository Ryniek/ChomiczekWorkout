package pl.rynski.chomiczek_workout.profile.model;

import javax.persistence.*;

@Entity
public class ChestSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chest_size_id")
    private Long id;
    private double size;

    public ChestSize() {
    }

    public ChestSize(double size) {
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
