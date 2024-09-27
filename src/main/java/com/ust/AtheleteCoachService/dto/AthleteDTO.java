package com.ust.AtheleteCoachService.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AthleteDTO(
        String id,
        String firstName,
        String lastName,
        LocalDate DOB,
        String email,
        String gender,
        String height,
        String coach_id
) {
    /*
    {
    "firstName": "John",
    "lastName": "Joe",
    "DOB": "1990-05-16",
    "email": "john.doe@example.com",
    "gender": "Male",
    "height": "180cm"
}
     */
}
