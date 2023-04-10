package com.example.social.services;

import java.util.List;
import java.util.Optional;

import com.example.social.Exception.PostException;
import com.example.social.Exception.UserException;
import com.example.social.model.Post;
import com.example.social.model.User;

public interface UserService {

	public User createUser(User user) throws UserException;
    
    public Optional<User> getUserById(Long id) throws UserException;
    
    public void deleteUserById(Long id) throws UserException;
    
    public void updateUserNameById(Long id, String name) throws UserException;
    
    public void updateUserBioById(Long id, String bio) throws UserException;
    
    public List<User> getTopActiveUsers() throws UserException;
    
    public int getTotalNumberOfUsers() throws UserException;
    
    public List<Post> getPostsByUserId(Long userId) throws PostException;
	
}
