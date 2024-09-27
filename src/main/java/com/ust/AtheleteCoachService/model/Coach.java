package com.ust.AtheleteCoachService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

//@EntityListeners(CoachListener.class)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coach {

    @Id
    private String coachId;
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

//class CoachListener {
//
//    @PrePersist  // This method will run before persisting the Coach entity
//    public void generateId(Coach coach) {
//        // Generates the Coach ID with a prefix
//        if (coach.getCoachId() == null) {
//            coach.setCoachId("COACH" + String.format("%05d", generateSequenceNumber()));
//        }
//    }
//
//    private int generateSequenceNumber() {
//        // You need to implement actual logic here (query DB for max ID or use a sequence generator)
//        // Here, we'll just return a random number for illustration purposes
//        return (int) (Math.random() * 100000); // Replace with real sequence logic
//    }
//}
