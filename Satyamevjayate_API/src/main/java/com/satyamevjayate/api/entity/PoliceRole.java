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



@Table(name="policerole")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoliceRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RoleID")
	private BigInteger roleID;
	@Column(name="RoleName")
	private String roleName;
	
	@OneToOne(mappedBy = "policeRole")
    @JsonIgnore
    private Police police;
	


	
	

}
