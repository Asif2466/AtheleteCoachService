package com.ust.AtheleteCoachService.dto;

public record AssistanceRequestDTO(
    int coach_id,
    String remarks,
    String merits,
    String goal,
    int athlete_id
) {
}
