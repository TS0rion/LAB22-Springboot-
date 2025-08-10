package com.likelion.lab22_spring_boot.exception;

public class ResourceNotFoundException
        extends RuntimeException {

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
