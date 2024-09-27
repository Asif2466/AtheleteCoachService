package com.ust.AtheleteCoachService.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AssistanceRequestDTO(
        String req_id,
    String coach_id,
    String remarks,
    String merits,
    String goal,
    String athlete_id
) {
}
