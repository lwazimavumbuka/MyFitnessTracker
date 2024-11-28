package com.myproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="macrosremaining")
public class MacrosRemaining {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Id;

    @Column
    private int kilojoules;

    @Column
    private int protein;

    @Column
    private int carbs;

    @Column
    private int fats;


    
    public MacrosRemaining() {
    }
    
    public MacrosRemaining(int kilojoules, int protein, int carbs, int fats) {
        this.kilojoules = kilojoules;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
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

    
}
