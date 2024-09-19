package com.ust.AtheleteCoachService.dto;

import java.time.LocalDate;

public record AthleteDTO(
        String firstName,
        String lastName,
        LocalDate DOB,
        String email,
        String gender,
        String height,
        int coach_id
) {
}
