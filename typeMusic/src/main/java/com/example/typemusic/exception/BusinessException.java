package com.example.typemusic.exception;

public class BusinessException extends RuntimeException{
    
    public BusinessException() {
    }

    public BusinessException(String s) {
        super(s);
    }
}
