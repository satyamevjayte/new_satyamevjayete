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
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="police")
public class Police {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PoliceID")
	private BigInteger	policeID;
	
	@Column(name="Pwd")
	private String pwd;
	
	@Column(name="PoliceCardImage")
	private Byte[] policeCardImage;
	
	@ManyToOne(optional=false)
    @JoinColumn(name = "AddressID")
    private Addresses policeAddress;
	
	@ManyToOne(optional=false)
    @JoinColumn(name = "RoleID")
    private PoliceRole policeRole;
	
	@ManyToOne(optional=false)
    @JoinColumn(name = "ContactId")
    private Contact policeContact;
	
	@ManyToOne(optional=false)
    @JoinColumn(name = "PersonID")
    private Person person;
	
	
	@ManyToOne(optional=false)
    @JoinColumn(name = "PoliceStationID")
    private PoliceStation policeStation;
	

}
