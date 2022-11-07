package com.example.typemusic.exception.config;

import lombok.Data;

@Data
public class ErrorBody {

    public ErrorBody(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    private Integer status;
    private String message;   

}
