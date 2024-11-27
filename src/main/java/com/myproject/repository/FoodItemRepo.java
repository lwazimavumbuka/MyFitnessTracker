package com.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.model.FoodItem;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem, Long>{

}
