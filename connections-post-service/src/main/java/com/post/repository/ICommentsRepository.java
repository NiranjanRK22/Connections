package com.post.repository;

import com.post.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentsRepository extends JpaRepository<Comments, Integer> {

    List<Comments> findByPostId(int postId);

    List<Comments> findByCommentContent(String content);
}
