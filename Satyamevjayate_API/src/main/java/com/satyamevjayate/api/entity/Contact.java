package com.satyamevjayate.api.entity;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ContactId")
	private BigInteger contactId;
	
	
	
	@Column(name="ContactNumber")
	private BigInteger contactNumber;
	
	@Column(name="ContactEmail")
	private String contactEmail;
	
	
	@OneToOne(mappedBy = "policeContact")
    @JsonIgnore
    private Police policeContact;
	
	@OneToMany(mappedBy = "suspectContact")
    @JsonIgnore
    private List<CrimeSuspect> crimeSuspectContact;
	
	@OneToMany(mappedBy = "crimeVictimeContact")
    @JsonIgnore
    private List<CrimeVictim> crimeVictimeContact;
	
	
	@OneToMany(mappedBy = "criminalContact")
    @JsonIgnore
    private List<Criminal> criminalContact;
	
	
	@OneToOne(mappedBy = "policeStationContact")
    @JsonIgnore
    private PoliceStation policeStationContact;
	
	@OneToOne(mappedBy = "workerContact")
    @JsonIgnore
    private Worker workerContact;
	

}
