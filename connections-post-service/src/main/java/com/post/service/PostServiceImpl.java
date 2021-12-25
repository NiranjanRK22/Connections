package com.post.service;

import com.post.exceptions.PostNotFoundException;
import com.post.model.Post;
import com.post.repository.IPostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements IPostService {
    private IPostRepository postRepository;
    private final Logger logger = LoggerFactory.getLogger(CommentsServiceImpl.class);

    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void updatePost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deletePost(int postId) {
        postRepository.deleteById(postId);
    }

    //    @Override
//    public Post getPostById(int postId) {
//        return postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException("Post not found"));
//    }
//
    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }
//
//    @Override
//    public List<Post> getByPostContent(String postContent)  throws PostNotFoundException {
////        List<Post> posts = postRepository.findByPostContent(postContent);
////        if (posts.isEmpty()) {
////            logger.info("Post not found");
////            logger.warn("PostNotFoundException");
////            throw new PostNotFoundException("Post not found");
////        }
//        return null;
//    }
}
