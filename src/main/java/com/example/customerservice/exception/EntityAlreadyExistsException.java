package com.example.customerservice.exception;

public class EntityAlreadyExistsException extends RuntimeException{
    public EntityAlreadyExistsException(String msg) {
        super(msg);
    }

}
