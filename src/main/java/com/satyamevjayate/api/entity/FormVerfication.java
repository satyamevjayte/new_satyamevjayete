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
    private BigInteger formVerifiactionID;
    @Column(name="ComplainerID")
    private BigInteger complainerID;
    @Column(name="PoliceID")
    private BigInteger policeID;
    @Column(name="WorkerID")
    private BigInteger workerID;
    @Column(name="ApplyDate")
    private BigInteger applyDate;
    @Column(name="VerifiedDate")
    private BigInteger verifiedDate;
    @Column(name="Status")
    private BigInteger status;

}
