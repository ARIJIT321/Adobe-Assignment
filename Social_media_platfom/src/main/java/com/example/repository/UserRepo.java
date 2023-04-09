package com.example.repository;

import org.springframework.stereotype.Repository;

import com.example.social.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

}
