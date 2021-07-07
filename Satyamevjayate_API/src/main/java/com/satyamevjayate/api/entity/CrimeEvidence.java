package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="crimeevidence")
public class CrimeEvidence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="EvidenceID")
    private Long    evidenceID;

  
    @Column(name = "CrimeID")
    private Long crimeEvidenceCrimeID;
//    @Column(name="CrimeID")
//    private Long    crimeID;

    @Column(name="Name")
    private String  name;

    @Column(name="Description")
    private String  description;
}
