package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="complainer")
public class Complainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ComplainerID")
    private Long   complainerID;



    @OneToOne(optional=false)
    @JoinColumn(name = "ResidenceAddressID")
    private Addresses complainerResidenceAddress;
    
    @OneToOne(optional=false)
    @JoinColumn(name = "PermanentAddressID")
    private Addresses complainerPermanentAddress;

    @ManyToOne(optional=false)
    @JoinColumn(name = "ContactId")
    private Contact complainerContact;
	
	@ManyToOne(optional=false)
    @JoinColumn(name = "PersonID")
    private Person complainerPerson;

    @Column(name="Pwd")
    private String pwd;
    
   

}
