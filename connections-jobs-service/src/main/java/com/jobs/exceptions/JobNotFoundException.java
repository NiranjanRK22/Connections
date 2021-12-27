package com.jobs.exceptions;

public class JobNotFoundException extends RuntimeException {

    public JobNotFoundException() {
    }

    public JobNotFoundException(String message) {
        super(message);
    }
}
