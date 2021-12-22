package com.user.model;

public enum OpenTo {
    OPENTOWORK("Open To Work"), HIRING("Hiring"), PROVIDINGSERVICES("Providing Services");

    public final String status;

    private OpenTo(String status) {
        this.status = status;
    }
}
