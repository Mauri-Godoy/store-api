package com.mg.store.config;

public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}