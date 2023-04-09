package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.social.model.Post;

public interface PostRepo extends JpaRepository<Post, Integer>{

	
	
}
