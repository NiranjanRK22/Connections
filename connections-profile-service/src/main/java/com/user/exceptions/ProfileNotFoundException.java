package com.user.exceptions;

public class ProfileNotFoundException extends RuntimeException {
    public ProfileNotFoundException() {
    }

    public ProfileNotFoundException(String message) {
        super(message);
    }
}
