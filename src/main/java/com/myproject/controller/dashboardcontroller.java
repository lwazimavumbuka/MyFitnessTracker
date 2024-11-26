package com.myproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myproject.model.Foods;
import com.myproject.model.Goals;
import com.myproject.repository.FoodsRepo;
import com.myproject.repository.GoalsRepo;

@Controller
public class DashboardController {

    @Autowired
    private GoalsRepo goalsRepo;

    @Autowired
    private FoodsRepo foodsRepo;
    
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

        List<Foods> foods = foodsRepo.findAll();
        model.addAttribute("foods", foods);

        return "dashboard";
    }
    
    @PostMapping("/edit-currentweight")
    public String editCurrentWeight(@RequestParam("currentweight") int currentweight){
        Optional<Goals> usergoals = goalsRepo.findById(usernameString);
        usergoals.get().setCurrentweight(currentweight);
        goalsRepo.save(usergoals.get());
        return "redirect:/dashboard?username="+usernameString;
    }

    @PostMapping("/new-weight")
    public String editWeightGoal(@RequestParam("newweight") int newweight){
        Optional<Goals> usergoals = goalsRepo.findById(usernameString);
        usergoals.get().setWeightgoal(newweight);
        goalsRepo.save(usergoals.get());
        return "redirect:/dashboard?username="+usernameString;
    }

    @PostMapping("/new-kilojoules")
    public String editKilojoules(@RequestParam("newkilojoules") int newkilojoules){
        Optional<Goals> usergoals = goalsRepo.findById(usernameString);
        usergoals.get().setKilojoules(newkilojoules);
        goalsRepo.save(usergoals.get());
        return "redirect:/dashboard?username="+usernameString;
    }

    @PostMapping("/new-carbs")
    public String editCarbs(@RequestParam("newcarbs") int newcarbs){
        Optional<Goals> usergoals = goalsRepo.findById(usernameString);
        usergoals.get().setCarbs(newcarbs);
        goalsRepo.save(usergoals.get());
        return "redirect:/dashboard?username="+usernameString;
    }

    @PostMapping("new-protein")
    public String editProtein(@RequestParam("newprotein") int newprotein){
        Optional<Goals> usergoals = goalsRepo.findById(usernameString);
        usergoals.get().setProtein(newprotein);
        goalsRepo.save(usergoals.get());
        return "redirect:/dashboard?username="+usernameString;
    }

    @PostMapping("/new-fats")
    public String editFats(@RequestParam("newfats") int newfats){
        Optional<Goals> usergoals = goalsRepo.findById(usernameString);
        usergoals.get().setFats(newfats);
        goalsRepo.save(usergoals.get());
        return "redirect:/dashboard?username="+usernameString;
    }

    @PostMapping("/log-item")
    public String addFood(@RequestParam("foodname") String foodname,
                            @RequestParam("kilojoules") int kilojoules,
                            @RequestParam("carbs") int carbs,
                            @RequestParam("protein") int protein,
                            @RequestParam("fats") int fats){
        Foods foods = new Foods(foodname, kilojoules, carbs, protein, fats);
        foodsRepo.save(foods);
        return "redirect:/dashboard?username="+usernameString;
    }
}
