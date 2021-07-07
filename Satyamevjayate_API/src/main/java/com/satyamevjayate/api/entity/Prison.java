package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="prison")
public class Prison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PrisonID")
    private Long    prisonID;

    @Column(name="PoliceID")
    private Long    policeID;

//    @Column(name="AddressID")
//    private Long    addressID;
    
    @OneToOne(optional=false)
	@JoinColumn(name = "AddressID")
	private Addresses prisonAddress;
	    
	
    @Column(name="PrisonName")
    private String  prisonName;
}
