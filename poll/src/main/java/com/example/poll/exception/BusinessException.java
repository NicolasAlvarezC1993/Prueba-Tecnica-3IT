package com.example.poll.exception;

public class BusinessException extends RuntimeException{
    
    public BusinessException() {
    }

    public BusinessException(String s) {
        super(s);
    }
}
