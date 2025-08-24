package com.github_gomestkd.restwithspringbootandmysqlerudioudemy.exception.handle;

import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.exception.ExceptionResponde;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.exception.RequiredObjectIsNullException;
import com.github_gomestkd.restwithspringbootandmysqlerudioudemy.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
@RestController
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

    // exceções e erros genéricos
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponde> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponde exceptionResponde = new ExceptionResponde(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(exceptionResponde, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponde> handleNotFoundException(Exception ex, WebRequest request) {
        ExceptionResponde exceptionResponde = new ExceptionResponde(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(exceptionResponde, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RequiredObjectIsNullException.class)
    public final ResponseEntity<ExceptionResponde> handleBadRequestExceptions(Exception ex, WebRequest request) {
        ExceptionResponde exceptionResponde = new ExceptionResponde(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(exceptionResponde, HttpStatus.BAD_REQUEST);
    }
}
