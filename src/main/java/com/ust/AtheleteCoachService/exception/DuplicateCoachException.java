package com.ust.AtheleteCoachService.exception;

public class DuplicateCoachException extends RuntimeException{
    public DuplicateCoachException(String message){
        super(message);
    }
}
