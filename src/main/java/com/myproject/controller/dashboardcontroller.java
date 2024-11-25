package com.myproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myproject.model.Goals;
import com.myproject.repository.GoalsRepo;


@Controller
public class DashboardController {

    @Autowired
    private GoalsRepo goalsRepo;
    
    private String usernameString;
    
    @GetMapping("/dashboard")
    public String dashboard(@RequestParam("username") String username, Model model){
        usernameString = username;
        Optional<Goals> usergoals = goalsRepo.findById(username);
        
        model.addAttribute("currentweight", usergoals.get().getCurrentweight()+"kg");
        model.addAttribute("weightgoal", usergoals.get().getWeightgoal()+"kg");
        model.addAttribute("kilojoules", usergoals.get().getKilojoules()+"kj per day");
        model.addAttribute("protein", usergoals.get().getProtein()+"g per day");
        model.addAttribute("carbs", usergoals.get().getCarbs()+"g per day");
        model.addAttribute("fats", usergoals.get().getFats()+"g per day");

        return "dashboard";
    }
    
    @PostMapping("/edit-currentweight")
    public String editCurrentWeight(@RequestParam("currentweight") int currentweight){
        Optional<Goals> usergoals = goalsRepo.findById(usernameString);
        usergoals.get().setCurrentweight(currentweight);
        goalsRepo.save(usergoals.get());
        return "dashboard";
    }
}
