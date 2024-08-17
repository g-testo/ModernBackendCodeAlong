package com.gt.modernBackend.services;

import com.gt.modernBackend.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PostService {
    ArrayList<Post> posts = new ArrayList<>(
            Arrays.asList(
                    new Post(1L, "Test Title", "Test Content")
            )
    );

    public List<Post> retrieveAllPosts(){
        return posts;
    }

    public Post retrievePostById(Long id){
        for(Post post: posts){
            if(post.getId().equals(id)){
                return post;
            }
        }
        return null;
    }

    public Post createPost(Post post){
        posts.add(post);
        return post;
    }

    public void updatePost(Long id, Post postBody){
        for(Post post: posts){
            if(post.getId().equals(id)){
                post.setTitle(postBody.getTitle());
                post.setContent(postBody.getContent());
                return;
            }
        }
    }

    public void deletePost(Long id){
        for(Post post: posts){
            if(post.getId().equals(id)) {
                posts.remove(post);
                return;
            }
        }
    }
}
