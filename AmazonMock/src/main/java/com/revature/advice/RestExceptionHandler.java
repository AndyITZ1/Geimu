package com.revature.advice;

import com.revature.exceptions.EmailAlreadyUsedException;
import com.revature.exceptions.OldPasswordException;
import com.revature.exceptions.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmailAlreadyUsedException.class)
    public ResponseEntity<Object> handleEmailAlreadyUsedException(HttpServletRequest request, EmailAlreadyUsedException emailAlreadyUsedException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(HttpServletRequest request, UserNotFoundException userNotFoundException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @ExceptionHandler(OldPasswordException.class)
    public ResponseEntity<Object> handleOldPasswordException(HttpServletRequest request, OldPasswordException oldPasswordException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}

