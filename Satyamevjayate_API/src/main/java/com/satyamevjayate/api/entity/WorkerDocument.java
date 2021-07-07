package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "workerdocument")

public class WorkerDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DocumentID")
    private Long documentID;

    
    @ManyToOne(optional=false)
    @JoinColumn(name = "WorkerID")
    private Worker workerDocument;

    
    @Column(name="DocumentType")
    private String documentType;
    @Column(name="DocumentImage")
    private Byte[] documentImage;
    @Column(name="Description")
    private String description;
    @Column(name="UploadDateTime")
    private Date uploadDateTime;

}
