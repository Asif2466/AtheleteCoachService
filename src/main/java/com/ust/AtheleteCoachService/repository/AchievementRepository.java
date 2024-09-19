package com.ust.AtheleteCoachService.repository;

import com.ust.AtheleteCoachService.model.Achievements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AchievementRepository extends JpaRepository<Achievements, Long> {
}
