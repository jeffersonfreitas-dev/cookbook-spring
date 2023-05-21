package dev.jeffersonfreitas.restapicookbok.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        final int code = HttpStatus.BAD_REQUEST.value();
        final String message = ex.getMessage();
        final List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(x -> x.getDefaultMessage()).collect(Collectors.toList());
        final ErrorDTO entity = new ErrorDTO(code, message, errors);
        return ResponseEntity.badRequest().body(entity);
    }

    @ExceptionHandler(TooManyRequestException.class)
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    public ErrorDTO handleTooManyRequestException(TooManyRequestException ex) {
        final int code = HttpStatus.TOO_MANY_REQUESTS.value();
        final String message = ex.getMessage();
        return new ErrorDTO(code, message);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleResourceNotFoundException(ResourceNotFoundException ex) {
        final int code = HttpStatus.NOT_FOUND.value();
        final String message = ex.getMessage();
        return new ErrorDTO(code, message);
    }
}
