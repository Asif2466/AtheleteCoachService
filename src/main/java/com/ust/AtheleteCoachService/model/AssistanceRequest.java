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
public class AssistanceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Req_seq")
    @SequenceGenerator(name = "Req_seq",initialValue = 300)
    private long Req_id;
    private Athlete athlete;
    private String Merits;
    private String Goal;
    private String remark;
    private RequestStatus status;

    @ManyToOne
    private Coach coach;
}
