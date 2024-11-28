package com.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.model.Meal;
import com.myproject.repository.MealRepo;

@RestController
@RequestMapping("api/meals")
public class MealController {

    @Autowired
    private MealRepo mealRepo;

    @GetMapping("/fetch")
    public ResponseEntity<List<Meal>> fetchMeals(){
        List<Meal> meals = mealRepo.findAll();

        return ResponseEntity.ok(meals);
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitMeal(@RequestBody Meal meal){
        mealRepo.save(meal);
        System.out.println(meal.toString());
        return ResponseEntity.ok("meal submitted");
    }
}
