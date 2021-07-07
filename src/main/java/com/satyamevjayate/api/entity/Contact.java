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

@NoArgsConstructor
@AllArgsConstructor
@Table(name="contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ContactId")
	private Long contactId;
	
	
	
	@Column(name="ContactNumber")
	private Long contactNumber;
	
	@Column(name="ContactEmail")
	private String contactEmail;
	
	
	@OneToOne(mappedBy = "policeContact")
    @JsonIgnore
    private Police policeContact;
	
	@OneToOne(mappedBy = "suspectContact")
    @JsonIgnore
    private CrimeSuspect crimeSuspectContact;
	
	@OneToOne(mappedBy = "crimeVictimeContact")
    @JsonIgnore
    private CrimeVictim crimeVictimeContact;
	
	
	@OneToOne(mappedBy = "criminalContact")
    @JsonIgnore
    private Criminal criminalContact;
	
	
	@OneToOne(mappedBy = "policeStationContact")
    @JsonIgnore
    private PoliceStation policeStationContact;
	
	@OneToOne(mappedBy = "workerContact")
    @JsonIgnore
    private Worker workerContact;
	
	@OneToOne(mappedBy = "complainerContact")
    @JsonIgnore
    private Complainer complainerContact;

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
}
