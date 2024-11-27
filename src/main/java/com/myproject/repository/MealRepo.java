package com.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.model.Meal;

@Repository
public interface MealRepo extends JpaRepository<Meal, Long> {

}
