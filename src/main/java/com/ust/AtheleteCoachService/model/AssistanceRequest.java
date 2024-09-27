package com.ust.AtheleteCoachService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

//@EntityListeners(RequestListener.class)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssistanceRequest {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Req_seq")
//    @GenericGenerator(
//            name = "request_seq",
//            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//            parameters = {
//                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "request_sequence"),
//                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
//                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
//            })
    @Id
    private String reqid;

    @OneToOne
    private Athlete athlete;
    private String Merits;
    private String Goal;
    private String remark;
    private RequestStatus status;

    @ManyToOne
    private Coach coach;
}

//class RequestListener {
//
//    @PrePersist  // This method will run before persisting the AssistanceRequest entity
//    public void generateId(AssistanceRequest request) {
//        // Generates the request ID with a prefix
//        if (request.getReqid() == null) {
//            request.setReqid("REQ" + String.format("%05d", generateSequenceNumber()));
//        }
//    }
//
//    private int generateSequenceNumber() {
//        // You need to implement actual logic here (query DB for max ID or use a sequence generator)
//        // Here, we'll just return a random number for illustration purposes
//        return (int) (Math.random() * 100000); // Replace with real sequence logic
//    }
//}
