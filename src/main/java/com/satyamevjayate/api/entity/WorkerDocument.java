package com.satyamevjayate.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    
    @ManyToOne(optional=false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
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
