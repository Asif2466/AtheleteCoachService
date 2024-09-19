package com.ust.AtheleteCoachService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Athlete {

    @Id
    @GeneratedValue
    private int AthleteId;
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

/*
TODO
  => create client inorder to iz
 */
