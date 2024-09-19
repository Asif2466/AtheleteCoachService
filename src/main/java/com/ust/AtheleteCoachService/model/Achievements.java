package com.ust.AtheleteCoachService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Achievements {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Ach_seq")
    @SequenceGenerator(name = "Ach_seq",initialValue = 400)
    private long achievementId;
    private String meetName;
    private String event;
    private String score;
    private String performance;

    @ManyToOne
    private Coach coach;

}
