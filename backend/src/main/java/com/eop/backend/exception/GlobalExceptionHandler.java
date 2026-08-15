package com.eop.backend.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFound(
            UserNotFoundException exception
    ) {
        Map<String, Object> errorResponse = Map.of(
                "timestamp", OffsetDateTime.now(),
                "status", HttpStatus.NOT_FOUND.value(),
                "error", "Not Found",
                "message", exception.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, Object>> handleDataIntegrityViolation(
        DataIntegrityViolationException exception
    ) {
        Map<String, Object> errorResponse = Map.of(
            "timestamp", OffsetDateTime.now(),
            "status", HttpStatus.CONFLICT.value(),
            "error", "Conflict",
            "message", "A user with this email already exists"
        );

        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(errorResponse);
    }
}