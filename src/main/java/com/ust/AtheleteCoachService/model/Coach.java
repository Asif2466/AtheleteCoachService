package com.ust.AtheleteCoachService.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "coaches")
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Using IDENTITY strategy for auto-increment
    @Column(name = "coach_id") // Ensuring the column name matches the database
    private int coachId;

    @Column(name = "first_name") // Matching column names
    private String firstName;

    @Column(name = "last_name") // Matching column names
    private String lastName;

    @Column(name = "dob") // Matching column names
    private LocalDate DOB;

    @Column(name = "email") // Matching column names
    private String email;

    @Column(name = "gender") // Matching column names
    private String gender;

    //@OneToMany(mappedBy = "coach", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Athlete> athletes;

   // @OneToMany(cascade = CascadeType.ALL)
  //  @JoinColumn(name = "coach_id") // Assuming this is the foreign key for achievements
    private List<Achievements> achievements;
}
