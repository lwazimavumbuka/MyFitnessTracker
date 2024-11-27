package com.myproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String exerciseName;

    @Column
    private String muscleGroup;

    @Column
    private int sets;

    @Column
    private int reps;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getExerciseName() {
        return exerciseName;
    }
    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }
    public String getMuscleGroup() {
        return muscleGroup;
    }
    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }
    public int getSets() {
        return sets;
    }
    public void setSets(int sets) {
        this.sets = sets;
    }
    public int getReps() {
        return reps;
    }
    public void setReps(int reps) {
        this.reps = reps;
    }
    @Override
    public String toString() {
        return "Exercise [id=" + id + ", exerciseName=" + exerciseName + ", muscleGroup=" + muscleGroup + ", sets="
                + sets + ", reps=" + reps + "]";
    }

    
}
