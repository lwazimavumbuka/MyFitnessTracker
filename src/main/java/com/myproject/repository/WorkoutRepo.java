package com.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.model.Workout;

@Repository
public interface WorkoutRepo extends JpaRepository<Workout, Long>{

}
