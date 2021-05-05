package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigInteger;
import java.util.List;

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

    
    @ManyToOne(optional=false)
    @JoinColumn(name = "AddressId")
    private Addresses suspectAddress;
	
    @ManyToOne(optional=false)
    @JoinColumn(name = "CrimeId")
    private Crime SuspectCrimeId;
    
	@ManyToOne(optional=false)
    @JoinColumn(name = "ContactId")
    private Contact suspectContact;
	
	@ManyToOne(optional=false)
    @JoinColumn(name = "PersonID")
    private Person suspectPerson;
	
	
	 @OneToMany(mappedBy = "crimeSuspectDocument")
	 @JsonIgnore
	 private List<CrimeSuspectDocument> crimeSuspectDocument;

}
