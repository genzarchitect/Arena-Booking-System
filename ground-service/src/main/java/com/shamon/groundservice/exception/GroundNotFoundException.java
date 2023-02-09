package com.shamon.groundservice.exception;

public class GroundNotFoundException extends RuntimeException{
    public GroundNotFoundException(String message){
        super(message);
    }
}
