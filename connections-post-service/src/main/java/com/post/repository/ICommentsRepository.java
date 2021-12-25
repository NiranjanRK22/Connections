package com.post.repository;

import com.post.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentsRepository extends JpaRepository<Comments, Integer> {

    @Query("from Comments c inner join c.post p where p.postId = ?1")
    List<Comments> findByPostId(int postId);

    @Query("from Comments c where comment LIKE %?1%")
    List<Comments> findByCommentContent(String content);
}
