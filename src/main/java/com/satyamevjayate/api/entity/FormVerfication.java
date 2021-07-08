package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="formverification")
public class FormVerfication {
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
    @Column(name="ApplyDate")
    private Long applyDate;
    @Column(name="VerifiedDate")
    private Long verifiedDate;
    @Column(name="Status")
    private Long status;

}
