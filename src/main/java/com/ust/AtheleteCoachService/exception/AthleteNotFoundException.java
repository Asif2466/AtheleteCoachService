package com.ust.AtheleteCoachService.exception;

public class AthleteNotFoundException extends RuntimeException{
    public AthleteNotFoundException(String message){
        super(message);
    }
}
