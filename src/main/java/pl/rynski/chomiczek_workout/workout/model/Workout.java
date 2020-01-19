package pl.rynski.chomiczek_workout.workout.model;

import pl.rynski.chomiczek_workout.workout.trainings.*;

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
    private List<AustralianPullUp> australianPullUpList = new ArrayList<>();
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<DiamondPushup> diamondPushupList = new ArrayList<>();
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<Dip> dipList = new ArrayList<>();
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<ImpossibleDip> impossibleDipList = new ArrayList<>();
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<OneBarDip> oneBarDipList = new ArrayList<>();
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<PlanchePushup> planchePushupList = new ArrayList<>();
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<PullUpUnder> pullUpUnderList = new ArrayList<>();
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<SkinTheCat> skinTheCatList = new ArrayList<>();
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<Squad> squadList = new ArrayList<>();
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<TigerPushup> tigerPushupList = new ArrayList<>();
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<HandstandPushup> handstandPushupList = new ArrayList<>();
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<PistolSquad> pistolSquadList = new ArrayList<>();
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<TrainingNote> notes = new ArrayList<>();

    public Workout() {
    }

    public List<HandstandPushup> getHandstandPushupList() {
        return handstandPushupList;
    }

    public void setHandstandPushupList(List<HandstandPushup> handstandPushupList) {
        this.handstandPushupList = handstandPushupList;
    }

    public List<PistolSquad> getPistolSquadList() {
        return pistolSquadList;
    }

    public void setPistolSquadList(List<PistolSquad> pistolSquadList) {
        this.pistolSquadList = pistolSquadList;
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


    public List<AustralianPullUp> getAustralianPullUpList() {
        return australianPullUpList;
    }

    public void setAustralianPullUpList(List<AustralianPullUp> australianPullUpList) {
        this.australianPullUpList = australianPullUpList;
    }

    public List<DiamondPushup> getDiamondPushupList() {
        return diamondPushupList;
    }

    public void setDiamondPushupList(List<DiamondPushup> diamondPushupList) {
        this.diamondPushupList = diamondPushupList;
    }

    public List<Dip> getDipList() {
        return dipList;
    }

    public void setDipList(List<Dip> dipList) {
        this.dipList = dipList;
    }

    public List<ImpossibleDip> getImpossibleDipList() {
        return impossibleDipList;
    }

    public void setImpossibleDipList(List<ImpossibleDip> impossibleDipList) {
        this.impossibleDipList = impossibleDipList;
    }

    public List<OneBarDip> getOneBarDipList() {
        return oneBarDipList;
    }

    public void setOneBarDipList(List<OneBarDip> oneBarDipList) {
        this.oneBarDipList = oneBarDipList;
    }

    public List<PlanchePushup> getPlanchePushupList() {
        return planchePushupList;
    }

    public void setPlanchePushupList(List<PlanchePushup> planchePushupList) {
        this.planchePushupList = planchePushupList;
    }

    public List<PullUpUnder> getPullUpUnderList() {
        return pullUpUnderList;
    }

    public void setPullUpUnderList(List<PullUpUnder> pullUpUnderList) {
        this.pullUpUnderList = pullUpUnderList;
    }

    public List<SkinTheCat> getSkinTheCatList() {
        return skinTheCatList;
    }

    public void setSkinTheCatList(List<SkinTheCat> skinTheCatList) {
        this.skinTheCatList = skinTheCatList;
    }

    public List<Squad> getSquadList() {
        return squadList;
    }

    public void setSquadList(List<Squad> squadList) {
        this.squadList = squadList;
    }

    public List<TigerPushup> getTigerPushupList() {
        return tigerPushupList;
    }

    public void setTigerPushupList(List<TigerPushup> tigerPushupList) {
        this.tigerPushupList = tigerPushupList;
    }

    public List<TrainingNote> getNotes() {
        return notes;
    }

    public void setNotes(List<TrainingNote> notes) {
        this.notes = notes;
    }
}
