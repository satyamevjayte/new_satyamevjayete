package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "crimevictim_document")
public class CrimeVictimDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DocumentID")
    private Long documentID;

    
    
    @ManyToOne(optional=false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "CrimeVictimId")
    private CrimeVictim crimeVictimDocumentID;

    @Column(name="DocumentType")
    private String documentType;
    @Column(name="DocumentImage")
    private Byte[] documentImage;
    @Column(name="Description")
    private String description;
    @Column(name="UploadDateTime")
    private Date uploadDateTime;
}
