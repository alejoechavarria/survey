package com.echavarria.survey.exceptions;

public class MissingRequiredDataException extends RuntimeException {
    public MissingRequiredDataException(String message) {
        super(message);
    }
}
