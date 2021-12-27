package com.post.controllers;

import com.post.model.Post;
import com.post.model.Profile;
import com.post.service.IPostService;
import com.post.service.IProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts-api")
public class PostController {
    private IPostService postService;

    private final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    public void setPostService(IPostService postService) {
        this.postService = postService;
    }

    private IProfileService profileService;

    public PostController(IProfileService profileService) {
        this.profileService = profileService;
    }

    //    @GetMapping("/profiles")
//    List<Profile> getAll()  {
//        return postService.getAll();
//    }

      @GetMapping("post/profiles/id/{profileId}")
      Profile showProfileById(@PathVariable("profileId") int profileId)  {
        return  profileService.getProfileById(profileId);
      }
//    @PostMapping("/post/create")
//    ResponseEntity<Post> createPost(@RequestBody Post post) {
//        HttpHeaders headers = new HttpHeaders();
//        Post newPost = postService.addPost(post);
//        logger.info("createPost()");
//        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(newPost);
//    }
//
//    @PutMapping("/post/update")
//    ResponseEntity<Void> updatePost(@RequestBody Post post) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("desc", "Track updated successfully");
//        postService.updatePost(post);
//        logger.info("updatePost()");
//        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
//    }
//
//    @DeleteMapping("/post/deleteById/{deleteById}")
//    ResponseEntity<Void> deletePost(@PathVariable("deleteById") int id) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("desc", "Track deleted successfully");
//        postService.deletePost(id);
//        logger.info("deletePost()");
//        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
//    }
//
//    @GetMapping("/post/postId/{postId}")
//    ResponseEntity<Post> getPostById(@PathVariable("postId") int id) {
//        HttpHeaders headers = new HttpHeaders();
//        Post post = postService.getPostById(id);
//        logger.info("getPostById()" + post);
//        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(post);
//    }
//
    @GetMapping("/posts")
    ResponseEntity<List<Post>> getAll() {
        HttpHeaders headers = new HttpHeaders();
        List<Post> posts = postService.getAll();
        logger.info("getAll()");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(posts);
    }
}
