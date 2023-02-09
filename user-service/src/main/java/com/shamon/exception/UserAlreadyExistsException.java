package com.shamon.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String userAlreadyExistsInDb) {
        super(userAlreadyExistsInDb);
    }
}
