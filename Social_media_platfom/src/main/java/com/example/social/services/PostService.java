package com.example.social.services;

import java.util.List;
import java.util.Optional;

import com.example.social.Exception.PostException;
import com.example.social.model.Post;

public interface PostService {

	public Post createPost(Post post) throws PostException;
    
    public Optional<Post> getPostById(Long id) throws PostException;
    
    public boolean deletePostById(Long id) throws PostException;
    
    public void updatePostContentById(Long id, String content) throws PostException;
    
    public Post incrementLikesById(Long id) throws PostException;
    
    public Post decrementLikesById(Long id) throws PostException;
    
    public List<Post> getTopLikedPosts() throws PostException;
    
    public int getTotalNumberOfPosts() throws PostException;
}
