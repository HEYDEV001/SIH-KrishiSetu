package com.SIH.KrishiSetu.KrishiSetu.advice;

import com.SIH.KrishiSetu.KrishiSetu.exception.ResourceNotFoundException;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.sasl.AuthenticationException;
import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> HandleResourceNotFoundException(ResourceNotFoundException e) {
        ApiError apierror = new ApiError(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apierror,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiError> handleAuthenticationException(AuthenticationException e) {
        ApiError apierror = new ApiError(e.getLocalizedMessage(), HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(apierror,HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ApiError> handleJwtException(JwtException e) {
        ApiError apierror = new ApiError(e.getLocalizedMessage(), HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(apierror,HttpStatus.UNAUTHORIZED);
    }



    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiError> handleAccessDeniedException(AccessDeniedException e) {
        ApiError apierror = new ApiError(e.getLocalizedMessage(), HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(apierror,HttpStatus.FORBIDDEN);
    }
}