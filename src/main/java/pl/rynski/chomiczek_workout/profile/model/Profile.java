package pl.rynski.chomiczek_workout.profile.model;

import javax.persistence.*;

import java.util.List;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    @OneToMany(mappedBy = "profile")
    private List<Weight> weightList;
    @OneToMany
    @JoinColumn(name = "profile_id", referencedColumnName = "chest_size_id")
    private List<ChestSize> chestSizeList;
    @OneToMany
    @JoinColumn(name = "profile_id", referencedColumnName = "arm_size_id")
    private List<ArmSize> armSizeList;
    @OneToMany
    @JoinColumn(name = "profile_id", referencedColumnName = "forearm_size_id")
    private List<ForearmSize> forearmSizeList;
    @OneToMany
    @JoinColumn(name = "profile_id", referencedColumnName = "thigh_size_id")
    private List<ThighSize> thighSizeList;
    @OneToMany
    @JoinColumn(name = "profile_id", referencedColumnName = "calf_size_id")
    private List<CalfSize> calfSizeList;
    @OneToMany
    @JoinColumn(name = "profile_id", referencedColumnName = "weight_id")
    private List<UpdateDate> dateList;

    public Profile() {
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

    public List<Weight> getWeightList() {
        return weightList;
    }

    public void setWeightList(List<Weight> weightList) {
        this.weightList = weightList;
    }

    public List<ChestSize> getChestSizeList() {
        return chestSizeList;
    }

    public void setChestSizeList(List<ChestSize> chestSizeList) {
        this.chestSizeList = chestSizeList;
    }

    public List<ArmSize> getArmSizeList() {
        return armSizeList;
    }

    public void setArmSizeList(List<ArmSize> armSizeList) {
        this.armSizeList = armSizeList;
    }

    public List<ForearmSize> getForearmSizeList() {
        return forearmSizeList;
    }

    public void setForearmSizeList(List<ForearmSize> forearmSizeList) {
        this.forearmSizeList = forearmSizeList;
    }

    public List<ThighSize> getThighSizeList() {
        return thighSizeList;
    }

    public void setThighSizeList(List<ThighSize> thighSizeList) {
        this.thighSizeList = thighSizeList;
    }

    public List<CalfSize> getCalfSizeList() {
        return calfSizeList;
    }

    public void setCalfSizeList(List<CalfSize> calfSizeList) {
        this.calfSizeList = calfSizeList;
    }

    public List<UpdateDate> getDateList() {
        return dateList;
    }

    public void setDateList(List<UpdateDate> dateList) {
        this.dateList = dateList;
    }
}
