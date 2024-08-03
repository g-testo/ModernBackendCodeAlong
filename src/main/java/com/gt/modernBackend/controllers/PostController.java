package com.gt.modernBackend.controllers;

import com.gt.modernBackend.models.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin()
public class PostController {
    LinkedList<Post> posts = new LinkedList<>(
            Arrays.asList(
                    new Post(1L, "Test Title", "Test Content")
            )
    );
    @GetMapping // http://localhost:8080/api/posts
    public List<Post> getAllPosts(){
        return posts;
    }

    @GetMapping("/{id}") // http://localhost:8080/api/posts/1
    public Post getPostById(@PathVariable Long id){
//        return postServices.getPostById(id);
        for(Post post: posts){
            if(post.getId().equals(id)){
                return post;
            }
        }
        return null;
    }

    @PostMapping // http://localhost:8080/api/posts
    public Post createPost(@RequestBody Post post){
        // Generate an autoincrement ID for the post
        Long tempId = (long) posts.size();
        post.setId(tempId);

        posts.add(post);
        return post;
    }

    @PutMapping("/{id}") // http://localhost:8080/api/posts/1
    public void updatePost(@PathVariable Long id, @RequestBody Post postBody){
        for(Post post: posts){
            if(post.getId().equals(id)){
                post.setTitle(postBody.getTitle());
                post.setContent(postBody.getContent());
                return;
            }
        }
    }

    @DeleteMapping("/{id}") // http://localhost:8080/api/posts/1
    public void deletePost(@PathVariable Long id){
        for(Post post: posts){
            if(post.getId().equals(id)) {
                posts.remove(post);
                return;
            }
        }
    }

}
