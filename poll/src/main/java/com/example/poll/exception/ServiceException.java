package com.example.poll.exception;

public class ServiceException  extends RuntimeException{

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }
    
}
