package com.user.service;


import com.user.model.Post;


public interface IPostService {
    Post addPost(Post post);

    void updatePost(Post post);

    void deletePost(int postId);


    //List<Profile> getAll();



//    Post getPostById(int postId) throws PostNotFoundException;

//    List<Post> getByPostContent(String postContent) throws PostNotFoundException;

}
