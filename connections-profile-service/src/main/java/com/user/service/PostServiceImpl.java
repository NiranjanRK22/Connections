package com.user.service;


import com.user.model.Post;
import com.user.repository.IPostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements IPostService {
    private IPostRepository postRepository;
    //private final Logger logger = LoggerFactory.getLogger(CommentsServiceImpl.class);

   // public static final String BASEURL = "http://PROFILE-SERVICE/profile-api";

   // private RestTemplate restTemplate;

//    public PostServiceImpl(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    @Autowired
    public void setPostRepository(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

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
//    public List<Profile> getAll() {
//        String url = BASEURL + "/profiles";
//        ResponseEntity<List> profileResponse = restTemplate.getForEntity(url, List.class);
//        List<Profile> profiles = profileResponse.getBody();
//        return profiles;
//    }

//    @Override
//    public Profile getProfileById(int profileId) {
//        String url = BASEURL + "/profiles/id/" + profileId;
//        Profile profile = restTemplate.getForObject(url, Profile.class);
//        return profile;
//    }

    //    @Override
//    public Post getPostById(int postId) {
//        return postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException("Post not found"));
//    }
//
//    @Override
//    public List<Profile> getAll() {
//        return postRepository.findAll();
//    }
////
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
