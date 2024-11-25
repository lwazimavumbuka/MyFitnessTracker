package com.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.model.Goals;

@Repository
public interface GoalsRepo extends JpaRepository<Goals, String>  {

}
