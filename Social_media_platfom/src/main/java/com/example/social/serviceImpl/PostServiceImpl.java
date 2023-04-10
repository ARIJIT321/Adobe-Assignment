package com.example.social.serviceImpl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.social.Exception.PostException;
import com.example.social.model.Post;
import com.example.social.repository.PostRepo;
import com.example.social.services.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
    PostRepo postRepository;
    
    
    public Post createPost(Post post) throws PostException{
        return postRepository.save(post);
    }
    
    public Optional<Post> getPostById(Long id) throws PostException{
        return postRepository.findById(id);
    }
    
    public boolean deletePostById(Long id) throws PostException{
    	Optional<Post> post = postRepository.findById(id);
    	if(post.isPresent()) {
    		postRepository.deleteById(id);
    		return true;
    	}else {
    		return false;
    		
    	}
        
    }
    
    public void updatePostContentById(Long id, String content) throws PostException{
    	Optional<Post> post = postRepository.findById(id);
    	if(post.isPresent()) {
    		Post p = post.get();
    		p.setContent(content);
    	}else {
    		throw new PostException("Id not available");
    	}
        
    }
    
    public Post incrementLikesById(Long id) throws PostException{
    	Optional<Post> post = postRepository.findById(id);
    	if(post.isPresent()) {
    		Post p = post.get();
    		p.setLikes(p.getLikes()+1);;
    		return p;
    	}else {
    		throw new PostException("Id not available");
    	}
    }
    
    public Post decrementLikesById(Long id) throws PostException{
    	Optional<Post> post = postRepository.findById(id);
    	if(post.isPresent()) {
    		Post p = post.get();
    		if(p.getLikes()>0) {
    			p.setLikes(p.getLikes()-1);
    			return p;
    		}
    		else {
    			throw new PostException("Likes can not be negetive");
    		}
    	}else {
    		throw new PostException("Id not available");
    	}
    }
    
    public List<Post> getTopLikedPosts() throws PostException{
    	List<Post> posts = postRepository.findAll();
    	if(posts.size()>=5) {
    		posts.sort((p1,p2)->{
        		return p1.getLikes()-p2.getLikes();
        	});
            List<Post> topfive = null;
            int i=0;
            for(Post p: posts) {
            	if(i<5) {
            		topfive.add(p);
            	}
            	i++;
            }
            return topfive;
    	}
    	else {
    		throw new PostException("Requried number of posts ar not avalable");
    	}
    }
    
    public int getTotalNumberOfPosts() throws PostException{
        return postRepository.findAll().size();
    }
}
