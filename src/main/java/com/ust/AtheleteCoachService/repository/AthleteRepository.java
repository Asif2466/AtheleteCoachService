package com.ust.AtheleteCoachService.repository;

import com.ust.AtheleteCoachService.model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AthleteRepository extends JpaRepository<Athlete, Integer> {

    Optional<Athlete> findByEmail(String email);

    Optional<Athlete> findByAthleteId(String id);

}
