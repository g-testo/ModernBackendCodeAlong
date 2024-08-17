package com.gt.modernBackend.services;

import com.gt.modernBackend.Repositories.PostRepository;
import com.gt.modernBackend.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostServiceInt{

    @Autowired
    PostRepository postRepository;

    public List<Post> retrieveAllPosts(){
        return postRepository.findAll();
    }

    public Post retrievePostById(Long id){
        return postRepository.findById(id).orElse(null);
    }

    public Post createPost(Post post){
        return postRepository.save(post);
    }

    public void updatePost(Long id, Post postBody){
        Post existingPost = postRepository.findById(id).orElse(null);
        if(existingPost != null){
            existingPost.setTitle(postBody.getTitle());
            existingPost.setContent(postBody.getContent());
            postRepository.save(existingPost);
        } else {
            System.out.println("Post not found");
        }
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}
