package com.ust.AtheleteCoachService.service;

import com.ust.AtheleteCoachService.dto.AssistanceRequestDTO;
import com.ust.AtheleteCoachService.dto.AthleteDTO;

public interface AthleteService {

    AthleteDTO createAthlete(AthleteDTO dto);

    AthleteDTO editAthlete(AthleteDTO dto);

    AssistanceRequestDTO requestAssistance(AssistanceRequestDTO dto, int athlete_id);

}
/*
TODO
  => create few more endpoints for open feign client services
 */