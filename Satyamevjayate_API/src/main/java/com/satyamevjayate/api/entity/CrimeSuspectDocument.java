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
@Table(name="crimesuspectdocument")
public class CrimeSuspectDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DocumentID")
    private BigInteger documentID;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "CrimeSuspectID")
    private CrimeSuspect crimeSuspectDocument;
    
  

    @Column(name="DocumentType")
    private String documentType;
    @Column(name="DocumentImage")
    private Byte[] documentImage;
    @Column(name="Description")
    private String description;
    @Column(name="UploadDateTime")
    private Date uploadDateTime;

}
