package com.post.service;

import com.post.exceptions.PostNotFoundException;
import com.post.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "PROFILE-SERVICE")
public interface IPostService {
    Post addPost(Post post);

    void updatePost(Post post);

    void deletePost(int postId);

    @GetMapping("profile-api/profiles")
    List<Post> getAll();

//    Post getPostById(int postId) throws PostNotFoundException;

//    List<Post> getByPostContent(String postContent) throws PostNotFoundException;

}
