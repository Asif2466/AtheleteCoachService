package com.ust.AtheleteCoachService.dto;

import java.time.LocalDate;

public record AthleteDTO(
        String firstName,
        String lastName,
        LocalDate DOB,
        String email,
        String gender,
        String height
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
