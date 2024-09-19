package com.ust.AtheleteCoachService.dto;

import java.time.LocalDate;

public record CoachDTO(
    String firstName,
    String lastName,
    LocalDate DOB,
    String email,
    String gender
) {
}
