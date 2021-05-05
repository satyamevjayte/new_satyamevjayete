package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="crimeimage")
public class CrimeImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CrimeImageID")
    private BigInteger crimeImageID;
//    @Column(name="CrimeID")
//    private BigInteger CrimeID;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "CrimeId")
    private Crime imageCrimeId;
    
    @Column(name="CrimeImage")
    private Byte[] crimeImage;
}
