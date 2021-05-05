package com.satyamevjayate.api.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="Crime")
public class Crime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CrimeID")
    private BigInteger crimeID;
    
    @Column(name="CrimeDate")
    private Date crimeDate;
    @Column(name="CrimeTime")
    private Date crimeTime;
    @Column(name="Description")
    private String description;
  
    @OneToOne(optional=false)
    @JoinColumn(name = "AddressID")
    private Addresses crimeAddress;
    
    @OneToOne(optional=false)
    @JoinColumn(name = "CrimeTypeID")
    private CrimeType crimeType;
    
    @OneToMany(mappedBy = "imageCrimeId")
    @JsonIgnore
    private List<CrimeImage> crimeImage;
    
    @OneToMany(mappedBy = "SuspectCrimeId")
    @JsonIgnore
    private List<CrimeSuspect> crimeSuspect;
    
    @OneToMany(mappedBy = "crimeVictimCrimeID")
    @JsonIgnore
    private List<CrimeVictim> crimeVictim;
    
   

}
