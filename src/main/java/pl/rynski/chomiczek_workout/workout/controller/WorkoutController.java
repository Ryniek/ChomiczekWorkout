package pl.rynski.chomiczek_workout.workout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.rynski.chomiczek_workout.profile.modelDto.ErrorMessage;
import pl.rynski.chomiczek_workout.workout.model.Summarize;
import pl.rynski.chomiczek_workout.workout.model.Workout;
import pl.rynski.chomiczek_workout.workout.model.WorkoutDto;
import pl.rynski.chomiczek_workout.workout.service.WorkoutService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WorkoutController {

    private WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping("/summarize")
    public String getHome(Model model, @ModelAttribute("errorMessage") ErrorMessage errorMessage) {
        Summarize summarize = new Summarize();
        model.addAttribute("summarize", summarize);
        model.addAttribute("errorMessage", errorMessage);
        return "summarizeWorkout";
    }

    @GetMapping("/sum")
    public String getSum(Model model) {
        model.addAttribute("test", workoutService.getQuantity());
        return "sum";
    }

    @GetMapping("/summarizeAll")
    public String getSummarize(@ModelAttribute("summarize") Summarize summarize, Model model) {
        model.addAttribute("workoutDto", new WorkoutDto());
        model.addAttribute("summarize", summarize);
        return "summarizePanel";
    }

    @PostMapping("/summarizeAll")
    public String addSummarize(@Valid @ModelAttribute WorkoutDto workoutDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            ErrorMessage errorMessage = new ErrorMessage(errors.get(0).getDefaultMessage());
            redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
            return "redirect:/summarize";
        }
        workoutService.addTraining(workoutDto);
        return "redirect:/summarize";
    }

    @PostMapping("/summarize")
    public String addTraining(@ModelAttribute Summarize summarize, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("summarize", summarize);
        return "redirect:/summarizeAll";
    }
}
