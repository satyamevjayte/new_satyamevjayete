package com.satyamevjayate.api.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="lawact")
public class LawAct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LawID")
	private Long lawID;
	
	@Column(name="LawName")
	private String lawName;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Punishment")
	private String punishment;


}
