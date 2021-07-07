package com.satyamevjayate.api.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="policestation")
public class PoliceStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="PoliceStationID")
    private Long policeStationID;
    
    @Column(name="StationName")
    private String stationName;



    @OneToOne(optional=false)
    @JoinColumn(name = "AddressID")
    private Addresses policestationAddress;
    
    
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "ContactID")
    private Contact policeStationContact;
    
    
    
   


}
