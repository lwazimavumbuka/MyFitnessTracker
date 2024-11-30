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
    private long currentweight;

    @Column(name="weight_goal")
    private long weightgoal;

    @Column(name="kilojoules")
    private long kilojoules;

    @Column(name="protein")
    private long protein;

    @Column(name="carbs")
    private long carbs;

    @Column(name="fats")
    private long fats;


    
    public Goals(String username, long currentweight, long weightgoal, long kilojoules, long protein, long carbs,
            long fats) {
        this.username = username;
        this.currentweight = currentweight;
        this.weightgoal = weightgoal;
        this.kilojoules = kilojoules;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
    }

    public Goals() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getCurrentweight() {
        return currentweight;
    }

    public void setCurrentweight(long currentweight) {
        this.currentweight = currentweight;
    }

    public long getWeightgoal() {
        return weightgoal;
    }

    public void setWeightgoal(long weightgoal) {
        this.weightgoal = weightgoal;
    }

    public long getKilojoules() {
        return kilojoules;
    }

    public void setKilojoules(long kilojoules) {
        this.kilojoules = kilojoules;
    }

    public long getProtein() {
        return protein;
    }

    public void setProtein(long protein) {
        this.protein = protein;
    }

    public long getCarbs() {
        return carbs;
    }

    public void setCarbs(long carbs) {
        this.carbs = carbs;
    }

    public long getFats() {
        return fats;
    }

    public void setFats(long fats) {
        this.fats = fats;
    }


    
    
}
