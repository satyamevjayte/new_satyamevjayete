package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="CrimeSuspect")
public class CrimeSuspect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CrimeSuspectID")
    private BigInteger crimeSuspectID;

    
    @ManyToOne(optional=false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "ResidenceAddressID")
    private Addresses suspectResidenceAddress;
    
    @ManyToOne(optional=false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "PermanentAddressID")
    private Addresses suspectPermanentAddress;
	
 
    @Column(name = "CrimeId")
    private Long SuspectCrimeId;
    
	@OneToOne(optional=false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "ContactId")
    private Contact suspectContact;
	
	@ManyToOne(optional=false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "PersonID")
    private Person suspectPerson;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "crimeSuspectDocument")
    @JsonIgnore
    private Set<CrimeSuspectDocument> crimeSuspectDocument;

}
