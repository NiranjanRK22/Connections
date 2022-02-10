package com.post.service;

import com.post.exceptions.CommentNotFoundException;
import com.post.model.Comments;
import com.post.repository.ICommentsRepository;
import org.apache.http.client.methods.RequestBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */

@Service
public class CommentsServiceImpl implements ICommentsService {

    @Autowired
    private ICommentsRepository commentsRepository;

    private final Logger logger = LoggerFactory.getLogger(CommentsServiceImpl.class);

    /**
     * @param comment
     * @return
     */
    @Override
    public Comments addComment(Comments comment) {
        return commentsRepository.save(comment);
    }

    /**
     * @param comment
     */
    @Override
    public void updateComment(Comments comment) {
        commentsRepository.save(comment);
    }

    /**
     * @param commentId
     */
    @Override
    public void deleteComment(int commentId) {
        commentsRepository.deleteByCommentId(commentId);
    }

    /**
     * @param commentId
     * @return
     */
    @Override
    public Comments getComment(int commentId) {
        return commentsRepository.findById(commentId).orElseThrow(() -> new CommentNotFoundException("Comment not found"));
    }


    @Override
    public List<Comments> getCommentsByPostId(int postId) throws CommentNotFoundException {
        List<Comments> comments = new ArrayList<Comments>();
        comments = commentsRepository.findCommentsByPostId(postId);

        if (comments.isEmpty()) {
            logger.warn("throws CommentNotFoundException");
            logger.error("Comments not found");
            throw new CommentNotFoundException("Comment not found");
        }

        return comments;
    }


    public List<Comments> getByCommentContent(String content) throws CommentNotFoundException {
        List<Comments> comments = commentsRepository.findByCommentContent(content);
        if (comments.isEmpty()) {
            logger.warn("throws CommentNotFoundException");
            logger.error("Comments not found");
            throw new CommentNotFoundException("Comment not found");
        }
        return comments;
    }
}
