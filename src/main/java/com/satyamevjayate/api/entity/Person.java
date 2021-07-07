package com.satyamevjayate.api.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Police> police;

    @OneToMany(mappedBy = "suspectPerson", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<CrimeSuspect> crimeSuspect;

    @OneToMany(mappedBy = "victimPerson", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<CrimeVictim> crimeVictim;

    @OneToMany(mappedBy = "criminalPerson", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Criminal> criminal;

    @OneToMany(mappedBy = "workerPerson", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Worker> worker;

    @OneToMany(mappedBy = "complainerPerson", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Complainer> complainerPerson;
    
  
    

}