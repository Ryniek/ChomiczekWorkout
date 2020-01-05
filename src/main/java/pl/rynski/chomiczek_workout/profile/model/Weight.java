package pl.rynski.chomiczek_workout.profile.model;

import javax.persistence.*;

@Entity
public class Weight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Profile profile;
    private double size;

    public Weight() {
    }

    public Weight(Profile profile, double size) {
        this.profile = profile;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
