package com.ust.AtheleteCoachService.repository;

import com.ust.AtheleteCoachService.model.AssistanceRequest;
import com.ust.AtheleteCoachService.model.Athlete;
import com.ust.AtheleteCoachService.model.Coach;
import com.ust.AtheleteCoachService.model.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssistanceRequestRepository extends JpaRepository<AssistanceRequest, Long> {

    boolean existsByCoachAndAthlete(Coach coach, Athlete athlete);

    List<AssistanceRequest> findAllByCoachAndStatus(Coach coach, RequestStatus status);

    Optional<AssistanceRequest> findByReqid(String id);

}
