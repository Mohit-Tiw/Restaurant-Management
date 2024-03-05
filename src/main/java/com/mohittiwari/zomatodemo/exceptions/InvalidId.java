package com.mohittiwari.zomatodemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidId extends RuntimeException{
    public InvalidId(String message){
        super(message);
    }
}
