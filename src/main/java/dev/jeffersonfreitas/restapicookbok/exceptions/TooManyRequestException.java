package dev.jeffersonfreitas.restapicookbok.exceptions;

public class TooManyRequestException extends RuntimeException{

    public TooManyRequestException(String message) {
        super(message);
    }
}
