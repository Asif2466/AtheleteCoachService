package com.ust.AtheleteCoachService.service;

import com.ust.AtheleteCoachService.dto.AssistanceRequestDTO;
import com.ust.AtheleteCoachService.dto.AthleteDTO;

import java.util.List;

public interface AthleteService {

    AthleteDTO createAthlete(AthleteDTO dto);

    AthleteDTO editAthlete(AthleteDTO dto, String id);

    AthleteDTO findAthlete(String id);

    List<AthleteDTO> findAllAthletes();

    AssistanceRequestDTO requestAssistance(AssistanceRequestDTO dto, String athlete_id);

}
/*
TODO
  => create few more endpoints for open feign client services
 */