package com.onlineshipping.backend.exception;

public class DetailNotFoundException extends RuntimeException {
    public DetailNotFoundException(Long id){

        super("Could not found the user with id "+id);
    }
}
