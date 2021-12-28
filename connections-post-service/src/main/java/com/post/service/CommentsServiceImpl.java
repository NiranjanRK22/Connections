package com.post.service;

import com.post.exceptions.CommentNotFoundException;
import com.post.model.Comments;
import com.post.repository.ICommentsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */

@Service
public class CommentsServiceImpl implements ICommentsService {
    private ICommentsRepository commentsRepository;
    private final Logger logger = LoggerFactory.getLogger(CommentsServiceImpl.class);

    /**
     *
     * @param comment
     * @return
     */
    @Override
    public Comments addComment(Comments comment) {
        return commentsRepository.save(comment);
    }

    /**
     *
     * @param comment
     */
    @Override
    public void updateComment(Comments comment) {
        commentsRepository.save(comment);
    }

    /**
     *
     * @param commentId
     */
    @Override
    public void deleteComment(int commentId) {
        commentsRepository.deleteById(commentId);
    }

    /**
     *
     * @param commentId
     * @return
     */
    @Override
    public Comments getComment(int commentId) {
        return commentsRepository.findById(commentId).orElseThrow(() -> new CommentNotFoundException("Comment not found"));
    }

    /**
     *
     * @param postId
     * @return
     * @throws CommentNotFoundException
     */
    @Override
    public List<Comments> getByPostId(int postId) throws CommentNotFoundException {
        List<Comments> comments = commentsRepository.findByPostId(postId);
        if (comments.isEmpty()) {
            logger.warn("throws CommentNotFoundException");
            logger.error("Comments not found");
            throw new CommentNotFoundException("Comment not found");
        }
        return comments;
    }

    /**
     *
     * @param content
     * @return
     * @throws CommentNotFoundException
     */
    @Override
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
