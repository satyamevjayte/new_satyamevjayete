package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="complainer_document")
public class ComplainerDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DocumentID")
    private Long   documentID;

    
    
    @Column(name = "ComplainerID")
    private Long complainerDocumentID;
  

    @Column(name="DocumentType")
    private String documentType;

    @Column(name="DocumentImage")
    private Byte[] documentImage;

    @Column(name="Description")
    private String description;

    @Column(name="UploadDateTime")
    private Date   uploadDateTime;


}
