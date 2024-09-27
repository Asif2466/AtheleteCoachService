package com.ust.AtheleteCoachService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;
import java.util.Date;

//@EntityListeners(AthleteListener.class)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Athlete {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "athlete_seq")
//    @GenericGenerator(
//            name = "athlete_seq",
//            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//            parameters = {
//                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "athlete_sequence"),
//                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
//                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
//            })
    @Id
    private String athleteId;
    private String firstName;
    private String LastName;
    private LocalDate DOB;
    private String email;
    private String gender;
    private String height;

    @OneToOne
    private Coach coach;

    @CreationTimestamp
    private Date createdDate;
}

//class AthleteListener {
//
//    @PrePersist  // This method will run before persisting the Athlete entity
//    public void generateId(Athlete athlete) {
//        // Generates the athlete ID with a prefix
//        if (athlete.getAthleteId() == null) {
//            athlete.setAthleteId("ATH" + String.format("%05d", generateSequenceNumber()));
//        }
//    }
//
//    private int generateSequenceNumber() {
//        // You need to implement actual logic here (query DB for max ID or use a sequence generator)
//        // Here, we'll just return a random number for illustration purposes
//        return (int) (Math.random() * 100000); // Replace with real sequence logic
//    }
//}

/*
TODO
  => create client inorder to iz
 */
