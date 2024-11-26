package com.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.model.Foods;

@Repository
public interface FoodsRepo extends JpaRepository<Foods, Integer> {

}
