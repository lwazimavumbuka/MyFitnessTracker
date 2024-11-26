package com.myproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Foods {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="foodname")
    private String foodname;

    @Column(name="kilojoules")
    private int kilojoules;

    @Column(name="carbs")
    private int carbs;

    @Column(name="protein")
    private int protein;

    @Column(name="fats")
    private int fats;

    
    @Override
    public String toString() {
        return "Foods [foodname=" + foodname + ", kilojoules=" + kilojoules + ", carbs=" + carbs + ", protein="
                + protein + ", fats=" + fats + "]";
    }
    public Foods() {
    }
    public Foods(String foodname, int kilojoules, int carbs, int protein, int fats) {
        this.foodname = foodname;
        this.kilojoules = kilojoules;
        this.carbs = carbs;
        this.protein = protein;
        this.fats = fats;
    }
    public String getFoodname() {
        return foodname;
    }
    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }
    public int getKilojoules() {
        return kilojoules;
    }
    public void setKilojoules(int kilojoules) {
        this.kilojoules = kilojoules;
    }
    public int getCarbs() {
        return carbs;
    }
    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }
    public int getProtein() {
        return protein;
    }
    public void setProtein(int protein) {
        this.protein = protein;
    }
    public int getFats() {
        return fats;
    }
    public void setFats(int fats) {
        this.fats = fats;
    }

    
}
