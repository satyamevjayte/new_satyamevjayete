package com.satyamevjayate.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
        private Long crimeVictimID;

        @ManyToOne(optional=false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
        @JoinColumn(name = "ResidenceAddressID")
        private Addresses victimResidenceAddress;
        
        @ManyToOne(optional=false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
        @JoinColumn(name = "PermanentAddressID")
        private Addresses victimPermanentAddress;
    	
        @OneToOne(optional=false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
        @JoinColumn(name = "CrimeId")
        private Crime crimeVictimCrimeID;
        
    	@OneToOne(optional=false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
        @JoinColumn(name = "ContactId")
        private Contact crimeVictimeContact;
    	
    	@ManyToOne(optional=false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
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
