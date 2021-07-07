package com.satyamevjayate.api.entity;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name="police")
public class Police {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PoliceID")
	private Long	policeID;
	
	@Column(name="Pwd")
	private String pwd;
	
	@Column(name="PoliceCardImage")
	private Byte[] policeCardImage;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "ResidenceAddressID")
	private Addresses policeResidenceAddress;
	    
	@ManyToOne(optional=false)
	@JoinColumn(name = "PermanentAddressID")
	private Addresses policePermanentAddress;
	
//	@ManyToOne(optional=false)
//    @JoinColumn(name = "RoleID")
//    private PoliceRole policeRole;
//	
	@OneToOne(optional=false)
    @JoinColumn(name = "ContactId")
    private Contact policeContact;
	
	@OneToOne(optional=false)
    @JoinColumn(name = "PersonID")
    private Person person;

	public Long getPoliceID() {
		return policeID;
	}

	public void setPoliceID(Long policeID) {
		this.policeID = policeID;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Byte[] getPoliceCardImage() {
		return policeCardImage;
	}

	public void setPoliceCardImage(Byte[] policeCardImage) {
		this.policeCardImage = policeCardImage;
	}

	public Addresses getPoliceResidenceAddress() {
		return policeResidenceAddress;
	}

	public void setPoliceResidenceAddress(Addresses policeResidenceAddress) {
		this.policeResidenceAddress = policeResidenceAddress;
	}

	public Addresses getPolicePermanentAddress() {
		return policePermanentAddress;
	}

	public void setPolicePermanentAddress(Addresses policePermanentAddress) {
		this.policePermanentAddress = policePermanentAddress;
	}

	public Contact getPoliceContact() {
		return policeContact;
	}

	public void setPoliceContact(Contact policeContact) {
		this.policeContact = policeContact;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Long getPoliceRoleID() {
		return policeRoleID;
	}

	public void setPoliceRoleID(Long policeRoleID) {
		this.policeRoleID = policeRoleID;
	}

	public Long getPoliceStationID() {
		return policeStationID;
	}

	public void setPoliceStationID(Long policeStationID) {
		this.policeStationID = policeStationID;
	}

	//	@ManyToOne(optional=false)
//    @JoinColumn(name = "PoliceStationID")
//    private PoliceStation policeStation;
//	
	@Column(name="RoleID")
	private Long policeRoleID;
	
	@Column(name="PoliceStationID")
	private Long policeStationID;
	

}
