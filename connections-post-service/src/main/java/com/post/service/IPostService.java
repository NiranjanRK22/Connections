package com.post.service;

import com.post.exceptions.PostNotFoundException;
import com.post.model.Post;

import java.util.List;

public interface IPostService {
    Post addPost(Post post);
    void updatePost(Post post);
    void deletePost(int postId);
    Post getPostById(int postId) throws PostNotFoundException;
    List<Post> getAll();
    List<Post> getByPostContent(String postContent) throws PostNotFoundException;

}
