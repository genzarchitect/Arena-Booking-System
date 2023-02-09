package com.shamon.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String noUserFound) {
        super(noUserFound);
    }
}
