package com.example.social.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.social.model.Post;

public interface PostRepo extends JpaRepository<Post, Long>{

	List<Post> findByUserId(Long userId);

	
	
}
