package com.satyamevjayate.api.entity;

import lombok.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name="worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="WorkerID")
    private BigInteger workerID;
    @Column(name="DateOfJoining")
    private Date dateOfJoining;
    @Column(name="DateOfResign")
    private Date dateOfResign;

    
    @OneToOne(optional=false)
    @JoinColumn( name = "AddressID")
    private Addresses workerAddress;
	
	@OneToOne(optional=false)
    @JoinColumn( name = "ContactID")
    private Contact workerContact;
	
	@OneToOne(optional=false)
    @JoinColumn(name = "PersonID")
    private Person workerPerson;
	
	@OneToOne(mappedBy = "workerDocument")
	@JsonIgnore
	private WorkerDocument workerDocument;

}
