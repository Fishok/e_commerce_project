package com.project.exceptions;

@SuppressWarnings("serial")
public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String message) {
        super(message);
    }
}