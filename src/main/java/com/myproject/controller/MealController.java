package com.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.model.Meal;
import com.myproject.repository.FoodItemRepo;
import com.myproject.repository.MealRepo;

@RestController
@RequestMapping("api/meals")
public class MealController {

    @Autowired
    private MealRepo mealRepo;

    @Autowired
    private FoodItemRepo foodItemRepo;

    @GetMapping("/fetch")
    public ResponseEntity<List<Meal>> fetchMeals(Model model){
        List<Meal> meals = mealRepo.findAll();
        return ResponseEntity.ok(meals);
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitMeal(@RequestBody Meal meal){
        meal.getFooditems().forEach(foodItem -> foodItem.setMeal(meal));
        mealRepo.save(meal);
        
        return ResponseEntity.ok("meal submitted");
    }
}
