package com.satyamevjayate.api.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;


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
    private Long crimeID;
    
    @Column(name="CrimeDate")
    private Date crimeDate;
    @Column(name="CrimeTime")
    private Date crimeTime;
    @Column(name="Description")
    private String description;
  
    @ManyToOne(optional=false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "AddressID")
    private Addresses crimeResidenceAddress;

 
    @Column(name = "CrimeTypeID")
    private Long crimeType;




    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "crimeVictimCrimeID")
    @JsonIgnore
    private Set<CrimeVictim> crimeVictim;
    
    
   
    
   

}
