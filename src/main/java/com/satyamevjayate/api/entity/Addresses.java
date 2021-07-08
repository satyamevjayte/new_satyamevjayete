package com.satyamevjayate.api.entity;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;


import javax.persistence.*;

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


	@OneToMany(mappedBy = "policeResidenceAddress", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Police> policeResidenceAddress;

	@OneToMany(mappedBy = "policePermanentAddress", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Police> policePermanentAddress;

	@OneToMany(mappedBy = "crimeResidenceAddress", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Crime> crimeResidenceAddress;


	@OneToMany(mappedBy = "suspectResidenceAddress", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<CrimeSuspect> crimeSuspectResidenceAddress;


	@OneToMany(mappedBy = "suspectPermanentAddress", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CrimeSuspect> crimeSuspectPermanentAddress;


	@OneToMany(mappedBy = "victimResidenceAddress", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<CrimeVictim> crimeVictimeResidenceAddress;


	@OneToMany(mappedBy = "victimPermanentAddress", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CrimeVictim> crimeVictimePermanentAddress;

	@OneToMany(mappedBy = "criminalResidenceAddress", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Criminal> criminalResidenceAddress;


	@OneToMany(mappedBy = "criminalPermanentAddress", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Criminal> criminalPermanentAddress;


	@OneToMany(mappedBy = "policestationAddress", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<PoliceStation> policeStationAddress;



	@OneToMany(mappedBy = "workerResidenceAddress", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Worker> workerResidenceAddress;


	@OneToMany(mappedBy = "workerPermanentAddress", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Worker> workerPermanentAddress;


	@OneToMany(mappedBy = "complainerResidenceAddress", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Complainer> complainerResidenceAddress;

	@OneToMany(mappedBy = "complainerPermanentAddress", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Complainer> complainerPermanentAddress;

	@OneToMany(mappedBy = "prisonAddress", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Prison> prisonAddress;

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
