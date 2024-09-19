package com.ust.AtheleteCoachService.exception;

public class DuplicateRequestException extends RuntimeException{
    public DuplicateRequestException(String message){
        super(message);
    }
}
