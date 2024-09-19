package com.ust.AtheleteCoachService.exception;

public class CoachNotFoundException extends RuntimeException{
    public CoachNotFoundException(String message){
        super(message);
    }
}
