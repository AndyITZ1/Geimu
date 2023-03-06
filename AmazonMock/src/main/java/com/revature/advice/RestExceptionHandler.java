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

    private String buildStackTrace(StackTraceElement[] traces) {
        String trace = "";
        for (int i = 0; i < 3; i++) {
            trace += traces[i].toString() + ", ";
        }
        trace += "...";
        return trace;
    }

    // User Exceptions
    @ExceptionHandler(EmailAlreadyUsedException.class)
    public ResponseEntity<Object> handleEmailAlreadyUsedException(HttpServletRequest request, EmailAlreadyUsedException e) {
        String error = "Email already taken or used by someone else!";
        return buildResponseEntity(new ErrorResponse(HttpStatus.CONFLICT, error, buildStackTrace(e.getStackTrace())));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(HttpServletRequest request, UserNotFoundException e) {
        String error = "No users found with given parameters.";
        return buildResponseEntity(new ErrorResponse(HttpStatus.NOT_FOUND, error, buildStackTrace(e.getStackTrace())));
    }

    @ExceptionHandler(OldPasswordException.class)
    public ResponseEntity<Object> handleOldPasswordException(HttpServletRequest request, OldPasswordException e) {
        String error = "Sorry, you entered an old password.";
        return buildResponseEntity(new ErrorResponse(HttpStatus.CONFLICT, error, buildStackTrace(e.getStackTrace())));
    }

    @ExceptionHandler(SameEmailUsedException.class)
    public ResponseEntity<Object> handleSameEmailUsedException(HttpServletRequest request, SameEmailUsedException e) {
        String error = "Your new email cannot be the same as your old email.";
        return buildResponseEntity(new ErrorResponse(HttpStatus.CONFLICT, error, buildStackTrace(e.getStackTrace())));
    }

    @ExceptionHandler(DeleteUserFailedException.class)
    public ResponseEntity<Object> handleDeleteUserFailedException(HttpServletRequest request, DeleteUserFailedException e) {
        String error = "User #" + e.getUserId() + "with the following email: " + e.getEmail() + " was not successfully deleted.";
        return buildResponseEntity(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, error, buildStackTrace(e.getStackTrace())));
    }

    // Product Exceptions
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(HttpServletRequest request, ProductNotFoundException e) {
        String error = "No products found with given parameters.";
        return buildResponseEntity(new ErrorResponse(HttpStatus.NOT_FOUND, error, buildStackTrace(e.getStackTrace())));
    }

    @ExceptionHandler(DeleteProductFailedException.class)
    public ResponseEntity<Object> handleDeleteProductFailedException(HttpServletRequest request, DeleteProductFailedException e) {
        String error = "Product #" + e.getProductId() + ": " + e.getProductName() + "was not successfully deleted.";
        return buildResponseEntity(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, error, buildStackTrace(e.getStackTrace())));
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse) {
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }
}

