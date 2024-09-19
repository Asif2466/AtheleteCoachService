package com.ust.AtheleteCoachService.exception;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private HashMap<Object, Object> response = new HashMap<>();

    @ExceptionHandler(AthleteNotFoundException.class)
    public ResponseEntity<Object> handleAthleteNotFoundException(AthleteNotFoundException ex){
        response.clear();
        logger.error("An error occurred...");
        response.put("message",ex.getMessage());
        response.put("status", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CoachNotFoundException.class)
    public ResponseEntity<Object> handleCoachNotFoundException(CoachNotFoundException ex){
        response.clear();
        logger.error("An error occurred...");
        response.put("message",ex.getMessage());
        response.put("status", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RequestNotFoundException.class)
    public ResponseEntity<Object> handleRequestNotFoundException(RequestNotFoundException ex){
        response.clear();
        logger.error("An error occurred...");
        response.put("message",ex.getMessage());
        response.put("status", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateAthleteException.class)
    public ResponseEntity<Object> handleDuplicateAthleteException(DuplicateAthleteException ex){
        response.clear();
        logger.error("An error occurred...");
        response.put("message",ex.getMessage());
        response.put("status", HttpStatus.CONFLICT);
        return new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DuplicateCoachException.class)
    public ResponseEntity<Object> handleDuplicateCoachException(DuplicateCoachException ex){
        response.clear();
        logger.error("An error occurred...");
        response.put("message",ex.getMessage());
        response.put("status", HttpStatus.CONFLICT);
        return new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DuplicateRequestException.class)
    public ResponseEntity<Object> handleDuplicateRequestException(DuplicateRequestException ex){
        response.clear();
        logger.error("An error occurred...");
        response.put("message",ex.getMessage());
        response.put("status", HttpStatus.CONFLICT);
        return new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }
}
