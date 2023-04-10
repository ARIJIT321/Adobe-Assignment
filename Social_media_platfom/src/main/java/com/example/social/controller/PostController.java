package com.example.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.social.Exception.PostException;
import com.example.social.model.Post;
import com.example.social.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
    
    @Autowired
    private PostService postService;

    @PostMapping("")
    public ResponseEntity<Post> createPost(@RequestBody Post post) throws PostException {
        Post createdPost = postService.createPost(post);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") Long id) throws PostException {
        Post post = postService.getPostById(id).get();
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") Long id, @RequestBody Post post) throws PostException {
        postService.updatePostContentById(id, post.getContent());
        
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") Long id) throws PostException {
        boolean deleted = postService.deletePostById(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{id}/like")
    public ResponseEntity<Post> likePost(@PathVariable("id") Long id) throws PostException {
        Post post = postService.incrementLikesById(id);
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping("/{id}/unlike")
    public ResponseEntity<Post> unlikePost(@PathVariable("id") Long id) throws PostException {
        Post post = postService.decrementLikesById(id);
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/analytics/posts")
    public ResponseEntity<Integer> getTotalPosts() throws PostException {
        int totalPosts = postService.getTotalNumberOfPosts();
        return new ResponseEntity<>(totalPosts, HttpStatus.OK);
    }

    @GetMapping("/analytics/posts/top-liked")
    public ResponseEntity<List<Post>> getTopLikedPosts() throws PostException {
        List<Post> topLikedPosts = postService.getTopLikedPosts();
        return new ResponseEntity<>(topLikedPosts, HttpStatus.OK);
    }
}
