package com.ust.AtheleteCoachService.repository;

import com.ust.AtheleteCoachService.model.Athlete;
import com.ust.AtheleteCoachService.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CoachRepository extends JpaRepository<Coach, Integer> {

    Optional<Coach> findByEmail(String email);

    Optional<Coach> findByCoachId(String id);

    List<Coach> findAllByFirstNameContainingIgnoreCase(String name);

}
