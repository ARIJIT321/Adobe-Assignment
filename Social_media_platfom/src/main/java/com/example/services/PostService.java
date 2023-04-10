package com.example.services;

import java.util.List;
import java.util.Optional;

import com.example.social.Exception.PostException;
import com.example.social.model.Post;

public interface PostService {

	public Post createPost(Post post) throws PostException;
    
    public Optional<Post> getPostById(Long id) throws PostException;
    
    public void deletePostById(Long id) throws PostException;
    
    public void updatePostContentById(Long id, String content) throws PostException;
    
    public void incrementLikesById(Long id) throws PostException;
    
    public void decrementLikesById(Long id) throws PostException;
    
    public List<Post> getTopLikedPosts(int limit) throws PostException;
    
    public int getTotalNumberOfPosts() throws PostException;
}
