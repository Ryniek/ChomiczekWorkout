package pl.rynski.chomiczek_workout.workout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.rynski.chomiczek_workout.account.repository.UserRepository;
import pl.rynski.chomiczek_workout.workout.model.*;
import pl.rynski.chomiczek_workout.workout.repository.WorkoutRepository;
import pl.rynski.chomiczek_workout.workout.trainings.*;

import java.time.LocalDate;
import java.util.List;

@Service
public class WorkoutService {

    private UserRepository userRepository;
    private WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutService(UserRepository userRepository, WorkoutRepository workoutRepository) {
        this.userRepository = userRepository;
        this.workoutRepository = workoutRepository;
    }

    public void createWorkout(Long id) {
        Workout workout = new Workout(id);
        workoutRepository.save(workout);
    }

    public void addTraining(WorkoutDto workoutDto) {
        Workout workout = workoutRepository.findById(getIdOfActiveUser()).get();
        LocalDate date = LocalDate.now();
        if(workoutDto.getPullUpsQuantity() != 0) {
            workout.getPullUpList().add(new PullUp(workoutDto.getPullUpsQuantity(), workout, date));
        }
        if(workoutDto.getPullUpsQuantity() == 0) {
            workout.getPullUpList().add(new PullUp(0, workout, date));
        }
        if(workoutDto.getPumpsQuantity() != 0) {
            workout.getPumpList().add(new Pump(workoutDto.getPumpsQuantity(), workout, date));
        }
        if(workoutDto.getPumpsQuantity() == 0) {
            workout.getPumpList().add(new Pump(0, workout, date));
        }
        if(workoutDto.getMuscleUpsQuantity() != 0) {
            workout.getMuscleUpList().add(new MuscleUp(workoutDto.getMuscleUpsQuantity(), workout, date));
        }
        if(workoutDto.getMuscleUpsQuantity() == 0) {
            workout.getMuscleUpList().add(new MuscleUp(0, workout, date));
        }

        if(workoutDto.getAustralianPullUpsQuantity() != 0) {
            workout.getAustralianPullUpList().add(new AustralianPullUp(workoutDto.getAustralianPullUpsQuantity(), workout, date));
        }
        if(workoutDto.getAustralianPullUpsQuantity() == 0) {
            workout.getAustralianPullUpList().add(new AustralianPullUp(0, workout, date));
        }
        if(workoutDto.getDiamondPushupsQuantity() != 0) {
            workout.getDiamondPushupList().add(new DiamondPushup(workoutDto.getDiamondPushupsQuantity(), workout, date));
        }
        if(workoutDto.getDiamondPushupsQuantity() == 0) {
            workout.getDiamondPushupList().add(new DiamondPushup(0, workout, date));
        }
        if(workoutDto.getDipsQuantity() != 0) {
            workout.getDipList().add(new Dip(workoutDto.getDipsQuantity(), workout, date));
        }
        if(workoutDto.getDipsQuantity() == 0) {
            workout.getDipList().add(new Dip(0, workout, date));
        }
        if(workoutDto.getImpossibleDipsQuantity() != 0) {
            workout.getImpossibleDipList().add(new ImpossibleDip(workoutDto.getImpossibleDipsQuantity(), workout, date));
        }
        if(workoutDto.getImpossibleDipsQuantity() == 0) {
            workout.getImpossibleDipList().add(new ImpossibleDip(0, workout, date));
        }
        if(workoutDto.getOneBarDipsQuantity() != 0) {
            workout.getOneBarDipList().add(new OneBarDip(workoutDto.getOneBarDipsQuantity(), workout, date));
        }
        if(workoutDto.getOneBarDipsQuantity() == 0) {
            workout.getOneBarDipList().add(new OneBarDip(0, workout, date));
        }
        if(workoutDto.getPlanchePushupsQuantity() != 0) {
            workout.getPlanchePushupList().add(new PlanchePushup(workoutDto.getPlanchePushupsQuantity(), workout, date));
        }
        if(workoutDto.getPlanchePushupsQuantity() == 0) {
            workout.getPlanchePushupList().add(new PlanchePushup(0, workout, date));
        }
        if(workoutDto.getPullUpsUnderQuantity() != 0) {
            workout.getPullUpUnderList().add(new PullUpUnder(workoutDto.getPullUpsUnderQuantity(), workout, date));
        }
        if(workoutDto.getPullUpsUnderQuantity() == 0) {
            workout.getPullUpUnderList().add(new PullUpUnder(0, workout, date));
        }
        if(workoutDto.getSkinTheCatQuantity() != 0) {
            workout.getSkinTheCatList().add(new SkinTheCat(workoutDto.getSkinTheCatQuantity(), workout, date));
        }
        if(workoutDto.getSkinTheCatQuantity() == 0) {
            workout.getSkinTheCatList().add(new SkinTheCat(0, workout, date));
        }
        if(workoutDto.getSquadsQuantity() != 0) {
            workout.getSquadList().add(new Squad(workoutDto.getSquadsQuantity(), workout, date));
        }
        if(workoutDto.getSquadsQuantity() == 0) {
            workout.getSquadList().add(new Squad(0, workout, date));
        }
        if(workoutDto.getTigerPushupsQuantity() != 0) {
            workout.getTigerPushupList().add(new TigerPushup(workoutDto.getTigerPushupsQuantity(), workout, date));
        }
        if(workoutDto.getTigerPushupsQuantity() == 0) {
            workout.getTigerPushupList().add(new TigerPushup(0, workout, date));
        }

        if(workoutDto.getNote() != null) {
            workout.getNotes().add(new TrainingNote(workoutDto.getNote(), workout));
        }
        if(workoutDto.getNote() == null) {
            workout.getNotes().add(new TrainingNote(" ", workout));
        }
        workoutRepository.save(workout);
    }

    public List<Pump> getQuantity() {
        return workoutRepository.findById(getIdOfActiveUser()).get().getPumpList();
    }

    private Long getIdOfActiveUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        Long id = userRepository.findByUsername(username).getId();
        return id;
    }
}
