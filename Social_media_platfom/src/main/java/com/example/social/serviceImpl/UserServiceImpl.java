package com.example.social.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.social.Exception.PostException;
import com.example.social.Exception.UserException;
import com.example.social.model.Post;
import com.example.social.model.User;
import com.example.social.repository.PostRepo;
import com.example.social.repository.UserRepo;
import com.example.social.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
    UserRepo userRepository;
	
	@Autowired
    PostRepo postRepository;
    
    
    
    public User createUser(User user) throws UserException{
        return userRepository.save(user);
    }
    
    public Optional<User> getUserById(Long id) throws UserException{
        return userRepository.findById(id);
    }
    
    public void deleteUserById(Long id) throws UserException{
        userRepository.deleteById(id);
    }
    
    public void updateUserNameById(Long id, String name) throws UserException{
        userRepository.updateNameById(id, name);
    }
    
    public void updateUserBioById(Long id, String bio) throws UserException{
        userRepository.updateBioById(id, bio);
    }
    
    public List<User> getTopActiveUsers() throws UserException{
        return userRepository.findTopNActiveUsers();
    }
    
    public int getTotalNumberOfUsers() throws UserException{
    	List<User> list=userRepository.findAll();
        return list.size();
    }
    
    public List<Post> getPostsByUserId(Long userId) throws PostException{
        return postRepository.findByUserId(userId);
    }
}
