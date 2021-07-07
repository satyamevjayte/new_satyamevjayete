package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="complainlaw")

public class ComplainLaw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ComplainLawID")
    private Long complainLawID;

    @Column(name="LawID")
    private Long lawID;

    @Column(name="ComplainID")
    private Long ComplainID;
}
