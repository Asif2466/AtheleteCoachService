package com.ust.AtheleteCoachService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coach {

    @Id
    @GeneratedValue
    private int coachId;
    private String firstName;
    private String LastName;
    private LocalDate DOB;
    private String email;
    private String gender;

    @OneToMany
    private List<Athlete> athletes;

    @OneToMany
    private List<Achievements> achievements;
}
