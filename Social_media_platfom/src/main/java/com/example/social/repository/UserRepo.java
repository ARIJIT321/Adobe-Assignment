package com.example.social.repository;

import org.springframework.stereotype.Repository;

import com.example.social.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{

	void updateNameById(Long id, String name);

	void updateBioById(Long id, String bio);

	List<User> findTopNActiveUsers();

}
