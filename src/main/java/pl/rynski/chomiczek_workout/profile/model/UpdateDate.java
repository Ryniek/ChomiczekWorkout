package pl.rynski.chomiczek_workout.profile.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class UpdateDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "update_date_id")
    private Long id;
    private LocalDate updateDate;

    public UpdateDate() {
    }

    public UpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }
}
