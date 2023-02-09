package com.shamon.Exceptions;

public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException(String Incorrect) {
        super(Incorrect);
    }
}
