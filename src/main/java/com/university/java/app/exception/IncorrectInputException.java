package com.university.java.app.exception;

public class IncorrectInputException extends Exception {

    public IncorrectInputException() {
        super();
    }

    public IncorrectInputException(String message) {
        super(message);
    }

    public IncorrectInputException(Exception e) {
        super(e);
    }

    public IncorrectInputException(String message, Exception e) {
        super(message, e);
    }
}
