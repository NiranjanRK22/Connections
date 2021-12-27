package com.post.service;

import com.post.exceptions.CommentNotFoundException;
import com.post.model.Comments;

import java.util.List;

public interface ICommentsService {
    Comments addComment(Comments comment);

    void updateComment(Comments comment);

    void deleteComment(int commentId);

//    Comments getComment(int commentId) throws CommentNotFoundException;
//
//    List<Comments> getByPostId(int postId) throws CommentNotFoundException;
//
//    List<Comments> getByCommentContent(String content) throws CommentNotFoundException;

}
