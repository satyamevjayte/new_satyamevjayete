package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="complain")
public class Complain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ComplainID")
    private Long complainID;

    @Column(name="ComplainerID")
    private Long complainerID;

    @Column(name="PoliceID")
    private Long policeID;

    @Column(name="Description")
    private String description;

    @Column(name="ComplainDateTime")
    private Date  complainDateTime;



}
