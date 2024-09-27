package com.ust.AtheleteCoachService.service;

import com.ust.AtheleteCoachService.dto.AssistanceRequestDTO;
import com.ust.AtheleteCoachService.dto.AthleteDTO;
import com.ust.AtheleteCoachService.dto.CoachDTO;
import com.ust.AtheleteCoachService.model.Achievements;
import com.ust.AtheleteCoachService.model.AssistanceRequest;
import com.ust.AtheleteCoachService.model.Coach;

import java.util.List;
import java.util.Optional;

public interface CoachService {

    CoachDTO createCoach(CoachDTO dto);

    CoachDTO editCoach(CoachDTO dto);

    List<CoachDTO> findAllCoaches();

    CoachDTO findCoach(String id);

    List<CoachDTO> searchByName(String name);

    String setAchievements(Achievements achievements,  String Coach_id);

    List<AssistanceRequestDTO> getAssistanceRequests(String Coach_id);

    String approveRequest(String req_id);

    String declineRequest(String req_id);

}
/*
TODO
    =>  use user id instead of coach_id after implementing Authentication service
 */