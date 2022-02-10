package com.post.repository;

import com.post.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentsRepository extends JpaRepository<Comments, Integer> {
    /**
     *
     * @param postId
     * @return
     */
//    @Query(value = "SELECT * from comments where postid =?1" ,nativeQuery = true)
    @Query("from Comments c inner join c.post p where p.postId=?1")
    List<Comments> findCommentsByPostId(int postId);

    /**
     *
     * @param content
     * @return
     */
    @Query("from Comments c where c.comment LIKE %?1%")
    List<Comments> findByCommentContent(String content);

    @Modifying
    @Query(value="delete from comments where commentid = ?1",nativeQuery = true)
    void deleteByCommentId(int commentId);

}
