package com.example.poll.exception;

public class DataAccessException  extends RuntimeException{

    public DataAccessException() {
    }

    public DataAccessException(String message) {
        super(message);
    }
    
}
