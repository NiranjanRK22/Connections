package com.post.controllers;

import com.post.exceptions.CommentNotFoundException;
import com.post.model.Comments;
import com.post.model.Like;
import com.post.model.Post;
import com.post.model.Profile;
import com.post.service.ICommentsService;
import com.post.service.ILikeService;
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

/**
 *
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/posts-api")
public class PostController {
    private IPostService postService;
    private ICommentsService commentsService;
    private ILikeService likeService;

    @Autowired
    public void setLikeService(ILikeService likeService) {
        this.likeService = likeService;
    }

    /**
     * @param commentsService
     */
    @Autowired
    public void setCommentsService(ICommentsService commentsService) {
        this.commentsService = commentsService;
    }

    private final Logger logger = LoggerFactory.getLogger(PostController.class);

    /**
     * @param postService
     */
    @Autowired
    public void setPostService(IPostService postService) {
        this.postService = postService;
    }

    private IProfileService profileService;

    /**
     * @param profileService
     */
    @Autowired
    public void setProfileService(IProfileService profileService) {
        this.profileService = profileService;
    }


    /**
     * @param profileId
     * @return
     */
    @GetMapping("post/profiles/id/{profileId}")
    Profile showProfileById(@PathVariable("profileId") int profileId) {
        return profileService.getProfileById(profileId);
    }

    /**
     * @param post
     * @return
     */
    @PostMapping("/post/create")
    ResponseEntity<Post> createPost(@RequestBody Post post) {
        HttpHeaders headers = new HttpHeaders();
        Post newPost = postService.addPost(post);
        logger.info("createPost()");
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(newPost);
    }

    /**
     * @param post
     * @return
     */
    @PutMapping("/post/update")
    ResponseEntity<Void> updatePost(@RequestBody Post post) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Track updated successfully");
        postService.updatePost(post);
        logger.info("updatePost()");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
    }

    /**
     * @param id
     * @return
     */
    @DeleteMapping("/comment/id/{deleteById}")
    ResponseEntity<Void> deleteComment(@PathVariable("deleteById") int id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Track deleted successfully");
        commentsService.deleteComment(id);
        logger.info("deletePost()");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
    }

    @DeleteMapping("/post/id/{deleteById}")
    ResponseEntity<Void> deletePost(@PathVariable("deleteById") int id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Track deleted successfully");
        postService.deletePost(id);
        logger.info("deletePost()");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
    }


    /**
     * @param id
     * @return
     */
    @GetMapping("/post/id/{postId}")
    ResponseEntity<Post> getPostById(@PathVariable("postId") int id) {
        HttpHeaders headers = new HttpHeaders();
        Post post = postService.getPostById(id);
        logger.info("getPostById()" + post);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(post);
    }

    /**
     * @return
     */
    @GetMapping("/posts")
    ResponseEntity<List<Post>> getAll() {
        HttpHeaders headers = new HttpHeaders();
        List<Post> posts = postService.getAll();
        logger.info("getAll()");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(posts);
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/posts/profile/{profileId}")
    ResponseEntity<List<Post>> getAllByProfileId(@PathVariable("profileId") int id) {
        HttpHeaders headers = new HttpHeaders();
        List<Post> posts = postService.getPostsByProfile(id);
        logger.info("getAllByProfileId()");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(posts);
    }

    /**
     * @param content
     * @return
     */
    @GetMapping("/posts/comments/{comment}")
    ResponseEntity<List<Comments>> getByCommentContent(@PathVariable("comment") String content) {
        HttpHeaders headers = new HttpHeaders();
        List<Comments> comments = commentsService.getByCommentContent(content);
        logger.info("get comments");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(comments);
    }

    /**
     * @param postContent
     * @return
     */
    @GetMapping("/posts/content/{content}")
    ResponseEntity<List<Post>> getByPostContent(@PathVariable("content") String postContent) {
        HttpHeaders headers = new HttpHeaders();
        List<Post> posts = postService.getByPostContent(postContent);
        logger.info("get posts");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(posts);

    }

    @GetMapping("/comments/id/{postId}")
    ResponseEntity<List<Comments>> getCommentsByPostId(@PathVariable("postId") int postId) {
        HttpHeaders headers = new HttpHeaders();
        List<Comments> comments = commentsService.getCommentsByPostId(postId);
        logger.info("get comments");
        System.out.println(comments);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(comments);
    }


    @PostMapping("/comments/create")
    ResponseEntity<Comments> addComment(@RequestBody Comments comments) {
        HttpHeaders headers = new HttpHeaders();
        Comments newComment = commentsService.addComment(comments);
        logger.info("createComment()");
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(newComment);
    }

    @PostMapping("/likes/create")
    ResponseEntity<Like> addLike(@RequestBody Like like) {
        HttpHeaders headers = new HttpHeaders();
        Like newLike = likeService.addLike(like);
        logger.info("createLike()");
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(newLike);
    }

    @DeleteMapping("/likes/id/{deleteById}")
    ResponseEntity<Like> deleteLike(@PathVariable("deleteById") int id) {
        HttpHeaders headers = new HttpHeaders();
        likeService.deleteLike(id);
        logger.info("deleteLike()");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
    }


}
