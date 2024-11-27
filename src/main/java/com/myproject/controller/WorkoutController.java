package com.myproject.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.model.Workout;
import com.myproject.repository.WorkoutRepo;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutRepo workoutRepo;

    @GetMapping
    public List<Workout> getAllWorkouts(){
        return workoutRepo.findAll();
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitWorkout(@RequestBody Workout workout){
        workoutRepo.save(workout);
        return ResponseEntity.ok("Workout saved successfully!");
   }
}

