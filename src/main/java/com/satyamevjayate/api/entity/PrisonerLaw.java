package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="prisonerlaw")
public class PrisonerLaw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PrisonerLawID")
    private Long prisonerLawID;

    @Column(name="LawID")
    private Long lawID;

    @Column(name="PrisonerID")
    private Long prisonerID;
}
