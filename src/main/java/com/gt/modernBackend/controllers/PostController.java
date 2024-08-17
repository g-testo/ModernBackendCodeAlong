package com.gt.modernBackend.controllers;

import com.gt.modernBackend.models.Post;
import com.gt.modernBackend.services.PostServiceImpl;
import com.gt.modernBackend.services.PostServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin()
public class PostController {
    @Autowired
    private PostServiceInt postService;

    @GetMapping // http://localhost:8080/api/posts
    public List<Post> getAllPosts(){
        return postService.retrieveAllPosts();
    }

    @GetMapping("/{id}") // http://localhost:8080/api/posts/1
    public Post getPostById(@PathVariable Long id){
        return postService.retrievePostById(id);
    }

    @PostMapping // http://localhost:8080/api/posts
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    @PutMapping("/{id}") // http://localhost:8080/api/posts/1
    public void updatePost(@PathVariable Long id, @RequestBody Post postBody){
        postService.updatePost(id, postBody);
    }

    @DeleteMapping("/{id}") // http://localhost:8080/api/posts/1
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }

}
