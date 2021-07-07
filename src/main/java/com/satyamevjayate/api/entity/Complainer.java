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
@Table(name="complainer",schema = "targetSchemaName")
public class Complainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ComplainerID")
    private Long   complainerID;



    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "ResidenceAddressID")
    private Addresses complainerResidenceAddress;
    
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "PermanentAddressID")
    private Addresses complainerPermanentAddress;

    @OneToOne(optional=false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "ContactId")
    private Contact complainerContact;
	
	@ManyToOne(optional=false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "PersonID")
    private Person complainerPerson;

    @Column(name="Pwd")
    private String pwd;
    
   

}
