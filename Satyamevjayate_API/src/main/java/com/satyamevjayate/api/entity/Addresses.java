package com.satyamevjayate.api.entity;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="addresses")
public class Addresses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="AddressID")
	private BigInteger addressID;
	
	@Column(name="AddressLine1")
	private String addressLine1;
	
	@Column(name="AddressLine2")
	private String addressLine2;
	
	@Column(name="ZipCode")
	private int zipcode;
	
	@Column(name="City")
	private String city;
	
	@Column(name="State")
	private String state;
	
	@Column(name="Country")
	private String country;
	
	
	@OneToOne(mappedBy = "policeAddress")
    @JsonIgnore
    private Police policeAddress;
	
	@OneToOne(mappedBy = "crimeAddress")
    @JsonIgnore
    private Crime crimeAddress;
	
	@OneToMany(mappedBy = "suspectAddress")
    @JsonIgnore
    private List<CrimeSuspect> crimeSuspect;
	
	@OneToMany(mappedBy = "victimAddress")
    @JsonIgnore
    private List<CrimeVictim> crimeVictime;
	
	
	@OneToOne(mappedBy = "criminalAddress")
    @JsonIgnore
    private Criminal criminalAddress;
	
	@OneToOne(mappedBy = "policeStationAddress")
    @JsonIgnore
    private PoliceStation policeStationAddress;
	
	@OneToOne(mappedBy = "workerAddress")
    @JsonIgnore
    private Worker workerAddress;
	
	

	

}
