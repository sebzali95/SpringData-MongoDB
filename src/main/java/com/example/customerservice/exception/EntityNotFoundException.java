package com.example.customerservice.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String msg) {
        super(msg);
    }

}
