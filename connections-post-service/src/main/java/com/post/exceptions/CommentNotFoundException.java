package com.post.exceptions;

public class CommentNotFoundException extends RuntimeException{
    public CommentNotFoundException() {
    }

    public CommentNotFoundException(String message) {
        super(message);
    }
}
