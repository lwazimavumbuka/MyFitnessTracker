package com.myproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="fooditem")
public class FoodItem {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long Id;

    @Column
    private String foodSelect;

    @Column
    private String foodAmount;

    @ManyToOne
    @JoinColumn(name="meal_id")
    private Meal meal;

    public String getFoodSelect() {
        return foodSelect;
    }

    public void setFoodSelect(String foodSelect) {
        this.foodSelect = foodSelect;
    }

    public String getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(String foodAmount) {
        this.foodAmount = foodAmount;
    }

    @Override
    public String toString() {
        return "FoodItem [foodSelect=" + foodSelect + ", foodAmount=" + foodAmount + "]";
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    
}
