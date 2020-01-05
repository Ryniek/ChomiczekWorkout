package pl.rynski.chomiczek_workout.profile.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<Weight> weightList = new ArrayList<>();
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<ChestSize> chestSizeList = new ArrayList<>();
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<ArmSize> armSizeList = new ArrayList<>();
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<ForearmSize> forearmSizeList = new ArrayList<>();
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<ThighSize> thighSizeList = new ArrayList<>();
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<CalfSize> calfSizeList = new ArrayList<>();
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<UpdateDate> dateList = new ArrayList<>();

    public Profile() {
    }

    public Profile(Long userId) {
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

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", userId=" + userId +
                ", weightList=" + weightList +
                ", chestSizeList=" + chestSizeList +
                ", armSizeList=" + armSizeList +
                ", forearmSizeList=" + forearmSizeList +
                ", thighSizeList=" + thighSizeList +
                ", calfSizeList=" + calfSizeList +
                ", dateList=" + dateList +
                '}';
    }
}
