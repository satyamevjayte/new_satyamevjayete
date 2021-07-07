package com.satyamevjayate.api.entity;

import java.math.BigInteger;
import java.util.List;


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

@AllArgsConstructor
@NoArgsConstructor
@Table(name="addresses")
public class Addresses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="AddressID")
	private Long addressID;
	
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
	
	
	@OneToMany(mappedBy = "policeResidenceAddress")
    @JsonIgnore
    private  List<Police> policeResidenceAddress;
	
	@OneToMany(mappedBy = "policePermanentAddress")
    @JsonIgnore
    private  List<Police> policePermanentAddress;
	
	@OneToOne(mappedBy = "crimeResidenceAddress")
    @JsonIgnore
    private Crime crimeResidenceAddress;
	
	@OneToMany(mappedBy = "suspectResidenceAddress")
    @JsonIgnore
    private List<CrimeSuspect> crimeSuspectResidenceAddress;
	
	@OneToMany(mappedBy = "suspectPermanentAddress")
    @JsonIgnore
    private List<CrimeSuspect> crimeSuspectPermanentAddress;
	
	@OneToMany(mappedBy = "victimResidenceAddress")
    @JsonIgnore
    private List<CrimeVictim> crimeVictimeResidenceAddress;
	
	@OneToMany(mappedBy = "victimPermanentAddress")
    @JsonIgnore
    private List<CrimeVictim> crimeVictimePermanentAddress;
	
	
	@OneToOne(mappedBy = "criminalResidenceAddress")
    @JsonIgnore
    private Criminal criminalResidenceAddress;
	
	@OneToOne(mappedBy = "criminalPermanentAddress")
    @JsonIgnore
    private Criminal criminalPermanentAddress;
	
	@OneToOne(mappedBy = "policestationAddress")
    @JsonIgnore
    private PoliceStation policeStationAddress;
	
	
	
	@OneToOne(mappedBy = "workerResidenceAddress")
    @JsonIgnore
    private Worker workerResidenceAddress;
	
	@OneToOne(mappedBy = "workerPermanentAddress")
    @JsonIgnore
    private Worker workerPermanentAddress;
	
	
	@OneToOne(mappedBy = "complainerResidenceAddress")
    @JsonIgnore
    private Complainer complainerResidenceAddress;
	
	@OneToOne(mappedBy = "complainerPermanentAddress")
    @JsonIgnore
    private Complainer complainerPermanentAddress;
	
	@OneToOne(mappedBy = "prisonAddress")
    @JsonIgnore
    private Prison prisonAddress;

	public Long getAddressID() {
		return addressID;
	}

	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
