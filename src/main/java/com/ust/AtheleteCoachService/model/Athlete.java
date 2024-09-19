package com.ust.AtheleteCoachService.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "athlete")
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Using IDENTITY strategy for auto-increment
    @Column(name = "athlete_id") // Ensuring the column name matches the database
    private int athleteId;

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

    @Column(name = "height") // Matching column names
    private String height;

    //@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   // @JoinColumn(name = "coach_id", referencedColumnName = "coach_id") // Ensure proper column mapping
    private Coach coach;

    @CreationTimestamp
    @Column(name = "created_date") // Matching column names
    private LocalDate createdDate;
}
