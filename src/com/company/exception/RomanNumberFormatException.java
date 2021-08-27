package com.company.exception;

public class RomanNumberFormatException extends RuntimeException {

    public RomanNumberFormatException(String errorMessage) {
        super(errorMessage);
    }
}
