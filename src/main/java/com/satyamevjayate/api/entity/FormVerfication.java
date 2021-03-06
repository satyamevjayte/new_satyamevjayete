package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

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

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "ComplainerID")
    private Complainer complainerName;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "PoliceID")
    private Police policeName;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "WorkerID")
    private Worker workerName;

    @Column(name="ApplayDate")
    private Date ApplyDate;
    @Column(name="VerifyDate")
    private Date VerifiedDate;
    @Column(name="Status")
    private String Status;

}
