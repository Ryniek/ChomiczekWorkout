package pl.rynski.chomiczek_workout.profile.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class UpdateDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Profile profile;
    private LocalDate updateDate;

    public UpdateDate() {
    }

    public UpdateDate(Profile profile, LocalDate updateDate) {
        this.profile = profile;
        this.updateDate = updateDate;
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

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }
}
