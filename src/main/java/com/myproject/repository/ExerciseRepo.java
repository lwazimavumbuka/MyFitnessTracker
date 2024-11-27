package com.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.model.Exercise;

public interface ExerciseRepo extends JpaRepository<Exercise, Long> {

}
