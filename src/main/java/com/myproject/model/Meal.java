package com.myproject.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="meal")
public class Meal {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long Id;

    @Column
    private String mealSlot;

    @OneToMany(mappedBy="meal")
    private List<FoodItem> fooditems;

    public String getMealSlot() {
        return mealSlot;
    }

    public void setMealSlot(String mealSlot) {
        this.mealSlot = mealSlot;
    }

    public List<FoodItem> getFooditems() {
        return fooditems;
    }

    public void setFooditems(List<FoodItem> fooditems) {
        this.fooditems = fooditems;
    }

    @Override
    public String toString() {
        return "Meal [mealSlot=" + mealSlot + ", fooditems=" + fooditems + "]";
    }

}
