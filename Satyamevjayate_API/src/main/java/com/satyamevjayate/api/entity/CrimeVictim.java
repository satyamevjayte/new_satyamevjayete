package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigInteger;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CrimeVictim")
public class CrimeVictim {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="CrimeVictimID")
        private BigInteger crimeVictimID;

        @ManyToOne(optional=false)
        @JoinColumn(name = "AddressId")
        private Addresses victimAddress;
    	
        @ManyToOne(optional=false)
        @JoinColumn(name = "CrimeId")
        private Crime crimeVictimCrimeID;
        
    	@ManyToOne(optional=false)
        @JoinColumn(name = "ContactId")
        private Contact crimeVictimeContact;
    	
    	@ManyToOne(optional=false)
        @JoinColumn(name = "PersonID")
        private Person victimPerson;
        
    	
    	@OneToMany(mappedBy = "crimeVictimDocumentID")
        @JsonIgnore
        private List<CrimeVictimDocument> crimeVictimDocument;
    	
        @Column(name="Height")
        private Double height;
        @Column(name="Weight")
        private BigInteger weight;
}
