package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="prisoners")
public class Prisoners {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PrisonerID")
    private Long    prisonerID;

    @Column(name="CrimeID")
    private Long    crimeID;

    @Column(name="CriminalID")
    private Long    criminalID;

//    @ManyToOne(optional=false)
//    @JoinColumn(name = "PersonID")
//    private Person prisonerPersonID;
    @Column(name="PrisonID")
    private Long prisonID;

    @Column(name="PrisoningTypeID")
    private Long prisoningTypeID;
    
    @Column(name="PrisioningStartDate")
    private Date  prisoningStartDate;

    @Column(name="PrisioningEndDate")
    private Date  prisoningEndDate;

    @Column(name="PrisonStatus")
    private String  prisonStatus;
}
