package com.revature.advice;

import com.revature.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    // User Exceptions
    @ExceptionHandler(EmailAlreadyUsedException.class)
    public ResponseEntity<Object> handleEmailAlreadyUsedException(HttpServletRequest request, EmailAlreadyUsedException e) {
        String error = "Email already taken or used by someone else! " + e.getMessage();
        return buildResponseEntity(new ErrorResponse(HttpStatus.CONFLICT, error));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(HttpServletRequest request, UserNotFoundException e) {
        String error = "No users found with given parameters." + e.getMessage();
        return buildResponseEntity(new ErrorResponse(HttpStatus.NOT_FOUND, error));
    }

    @ExceptionHandler(OldPasswordException.class)
    public ResponseEntity<Object> handleOldPasswordException(HttpServletRequest request, OldPasswordException e) {
        String error = "Sorry, you entered an old password. " + e.getMessage();
        return buildResponseEntity(new ErrorResponse(HttpStatus.CONFLICT, error));
    }

    @ExceptionHandler(SameEmailUsedException.class)
    public ResponseEntity<Object> handleSameEmailUsedException(HttpServletRequest request, SameEmailUsedException e) {
        String error = "Your new email cannot be the same as your old email." + e.getMessage();
        return buildResponseEntity(new ErrorResponse(HttpStatus.CONFLICT, error));
    }

    // Product Exceptions
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(HttpServletRequest request, ProductNotFoundException e) {
        String error = "No products found with given parameters." + e.getMessage();
        return buildResponseEntity(new ErrorResponse(HttpStatus.NOT_FOUND, error));
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse) {
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }
}

