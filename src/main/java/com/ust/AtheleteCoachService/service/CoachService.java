package com.ust.AtheleteCoachService.service;

import com.ust.AtheleteCoachService.dto.AssistanceRequestDTO;
import com.ust.AtheleteCoachService.dto.CoachDTO;
import com.ust.AtheleteCoachService.model.Achievements;
import com.ust.AtheleteCoachService.model.AssistanceRequest;

import java.util.List;

public interface CoachService {

    CoachDTO createCoach(CoachDTO dto);

    CoachDTO editCoach(CoachDTO dto);

    List<CoachDTO> findAllCoaches();

    List<CoachDTO> searchByName(String name);

    String setAchievements(Achievements achievements,  int Coach_id);

    List<AssistanceRequestDTO> getAssistanceRequests(int Coach_id);

    String approveRequest(long req_id);

    String declineRequest(long req_id);

}
/*
TODO
    =>  use user id instead of coach_id after implementing Authentication service
 */