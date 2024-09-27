package com.ust.AtheleteCoachService.repository;

import com.ust.AtheleteCoachService.model.Achievements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AchievementRepository extends JpaRepository<Achievements, Long> {
    Optional<Achievements> findByAchievementId(String id);
}
