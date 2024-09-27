package com.ust.AtheleteCoachService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

//@EntityListeners(AthleteListener.class)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Achievements {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Ach_seq")
//    @GenericGenerator(
//            name = "Ach_seq",
//            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//            parameters = {
//                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "achievement_sequence"),
//                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
//                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
//            })
    @Id
    private String achievementId;
    private String meetName;
    private String event;
    private String score;
    private String performance;

    @ManyToOne
    private Coach coach;
}

//class AchievementListener {
//
//    @PrePersist  // This method will run before persisting the Achievement entity
//    public void generateId(Achievements achievements) {
//        // Generates the achievement ID with a prefix
//        if (achievements.getAchievementId() == null) {
//            achievements.setAchievementId("ACH" + String.format("%05d", generateSequenceNumber()));
//        }
//    }
//
//    private int generateSequenceNumber() {
//        // You need to implement actual logic here (query DB for max ID or use a sequence generator)
//        // Here, we'll just return a random number for illustration purposes
//        return (int) (Math.random() * 100000); // Replace with real sequence logic
//    }
//}
