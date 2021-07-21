package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="formverification")
public class FromVerfication1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="FormVerificationID")
    private Long formVerifiactionID;

    @Column(name="ComplainerID")
    private Long complainerID;

    @Column(name="PoliceID")
    private Long policeID;

    @Column(name="WorkerID")
    private Long workerID;

    @Column(name="ApplayDate")
    private Date ApplyDate;
    @Column(name="VerifyDate")
    private Date VerifiedDate;
    @Column(name="Status")
    private String Status;
}
