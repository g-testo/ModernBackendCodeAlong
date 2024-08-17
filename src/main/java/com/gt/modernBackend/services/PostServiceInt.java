package com.gt.modernBackend.services;

import com.gt.modernBackend.Repositories.PostRepository;
import com.gt.modernBackend.models.Post;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface PostServiceInt {
    public List<Post> retrieveAllPosts();
    public Post retrievePostById(Long id);
    public Post createPost(Post post);
    public void updatePost(Long id, Post postBody);
    public void deletePost(Long id);
}
