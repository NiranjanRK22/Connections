package com.user.repository;


import com.user.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<Post, Integer> {
//    List<Post> findByPostContent(String postContent);
     //List<Post> findByProfile(String profile);
}
