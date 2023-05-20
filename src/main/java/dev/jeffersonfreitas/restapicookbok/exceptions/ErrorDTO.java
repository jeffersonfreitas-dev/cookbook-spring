package dev.jeffersonfreitas.restapicookbok.exceptions;

import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ErrorDTO {

    private int code;
    private String message;
    private ZonedDateTime timestamp;
    private List<String> errors = new ArrayList<String>();

    public ErrorDTO(int code, String message){
        this.timestamp = ZonedDateTime.now();
        this.code = code;
        this.message = message;
    }

    public ErrorDTO(int code, String message, List<String> errors){
        this(code, message);
        this.errors = errors;
    }
}
