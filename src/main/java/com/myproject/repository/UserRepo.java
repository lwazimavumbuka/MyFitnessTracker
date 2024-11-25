package com.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{

}
