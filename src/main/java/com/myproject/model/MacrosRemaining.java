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
    private long kilojoules;

    @Column
    private long protein;

    @Column
    private long carbs;

    @Column
    private long fats;


    
    public MacrosRemaining() {
    }
    
    public MacrosRemaining(long kilojoules, long protein, long carbs, long fats) {
        this.kilojoules = kilojoules;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
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
