package com.satyamevjayate.api.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PersonId")
    private BigInteger personId;

    @Column(name="FirstName")
    private String firstName;

    @Column(name="LastName")
    private String lastName;

    @Column(name="DateOfBirth")
    private Date dateOfBirth;

    @Column(name="Gender")
    private String gender;

    @Column(name="PersonImage")
    private byte[] personImage;

    @OneToOne(mappedBy = "person")
    @JsonIgnore
    private Police police;
    
    @OneToOne(mappedBy = "suspectPerson")
    @JsonIgnore
    private CrimeSuspect crimeSuspect;
    
    
    @OneToOne(mappedBy = "victimPerson")
    @JsonIgnore
    private CrimeVictim crimeVictim;
    
    @OneToOne(mappedBy = "criminalPerson")
    @JsonIgnore
    private Criminal criminal;
    
    @OneToOne(mappedBy = "workerPerson")
    @JsonIgnore
    private Worker worker;
    
    @OneToOne(mappedBy = "complainerPerson")
    @JsonIgnore
    private Complainer complainerPerson;
    
  
    

}