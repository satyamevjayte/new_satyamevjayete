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
@Table(name="policedocument")
public class PoliceDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DocumentID")
    private Long   documentID;

    @Column(name="PoliceID")
	private Long policeDocumentID;
//    @Column(name="PoliceID")
//    private Long   policeID;

    @Column(name="DocumentType")
    private String documentType;

    @Column(name="DocumentImage")
    private Byte[] documentImage;

    @Column(name="Description")
    private String description;

    @Column(name="UploadDateTime")
    private Date uploadDateTime;
}
