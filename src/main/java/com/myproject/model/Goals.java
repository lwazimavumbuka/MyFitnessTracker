package com.myproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="goals")
public class Goals {
    @Id
    private String username;

    @Column(name="current_weight")
    private int currentweight;

    @Column(name="weight_goal")
    private int weightgoal;

    @Column(name="kilojoules")
    private int kilojoules;

    @Column(name="protein")
    private int protein;

    @Column(name="carbs")
    private int carbs;

    @Column(name="fats")
    private int fats;


    public Goals() {
    }
    public Goals(String username, int currentweight, int weightgoal, int kilojoules, int protein, int carbs, int fats) {
        this.username = username;
        this.currentweight = currentweight;
        this.weightgoal = weightgoal;
        this.kilojoules = kilojoules;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getCurrentweight() {
        return currentweight;
    }
    public void setCurrentweight(int currentweight) {
        this.currentweight = currentweight;
    }
    public int getWeightgoal() {
        return weightgoal;
    }
    public void setWeightgoal(int weightgoal) {
        this.weightgoal = weightgoal;
    }
    public int getKilojoules() {
        return kilojoules;
    }
    public void setKilojoules(int kilojoules) {
        this.kilojoules = kilojoules;
    }
    public int getProtein() {
        return protein;
    }
    public void setProtein(int protein) {
        this.protein = protein;
    }
    public int getCarbs() {
        return carbs;
    }
    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }
    public int getFats() {
        return fats;
    }
    public void setFats(int fats) {
        this.fats = fats;
    }
    @Override
    public String toString() {
        return "Goals [username=" + username + ", currentweight=" + currentweight + ", weightgoal=" + weightgoal
                + ", kilojoules=" + kilojoules + ", protein=" + protein + ", carbs=" + carbs + ", fats=" + fats + "]";
    }
    
}
