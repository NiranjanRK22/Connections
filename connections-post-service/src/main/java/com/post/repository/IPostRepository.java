package com.post.repository;

import com.post.model.Post;
import com.post.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<Post, Integer> {
    /**
     *
     * @param postContent
     * @return
     */
    @Query("from Post p where p.description LIKE %?1%")
    List<Post> findByPostContent(String postContent);

    /**
     *
     * @param profileId
     * @return
     */
    @Query("from Post p inner join p.profile pf where pf.profileId = ?1")
    List<Post> findPostsByProfile(int profileId);
}
