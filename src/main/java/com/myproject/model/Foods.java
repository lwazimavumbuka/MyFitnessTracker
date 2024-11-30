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
    private long kilojoules;

    @Column(name="carbs")
    private long carbs;

    @Column(name="protein")
    private long protein;

    @Column(name="fats")
    private long fats;

    
    @Override
    public String toString() {
        return "Foods [foodname=" + foodname + ", kilojoules=" + kilojoules + ", carbs=" + carbs + ", protein="
                + protein + ", fats=" + fats + "]";
    }
    public Foods() {
    }
    public Foods(String foodname, long kilojoules, long carbs, long protein, long fats) {
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
    public long getKilojoules() {
        return kilojoules;
    }
    public void setKilojoules(long kilojoules) {
        this.kilojoules = kilojoules;
    }
    public long  getCarbs() {
        return carbs;
    }
    public void setCarbs(long carbs) {
        this.carbs = carbs;
    }
    public long getProtein() {
        return protein;
    }
    public void setProtein(long protein) {
        this.protein = protein;
    }
    public long getFats() {
        return fats;
    }
    public void setFats(long fats) {
        this.fats = fats;
    }

    
}
