package com.post.service;

import com.post.exceptions.PostNotFoundException;
import com.post.model.Post;
import com.post.model.Profile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


public interface IPostService {

    Post addPost(Post post);

    void updatePost(Post post);

    void deletePost(int postId);

    List<Post> getAll();

    Post getPostById(int postId) throws PostNotFoundException;

    List<Post> getPostsByProfile(int profileId) throws PostNotFoundException;

    List<Post> getByPostContent(String postContent) throws PostNotFoundException;


}
