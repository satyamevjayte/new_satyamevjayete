package com.satyamevjayate.api.entity;

import lombok.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    private Long workerID;
    @Column(name="DateOfJoining")
    private Date dateOfJoining;
    @Column(name="DateOfResign")
    private Date dateOfResign;

    
    @ManyToOne(optional=false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "ResidenceAddressID")
	private Addresses workerResidenceAddress;
	    
	@ManyToOne(optional=false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "PermanentAddressID")
	private Addresses workerPermanentAddress;
	
	@OneToOne(optional=false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn( name = "ContactID")
    private Contact workerContact;
	
	@ManyToOne(optional=false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "PersonID")
    private Person workerPerson;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "workerDocument")
	@JsonIgnore
	private List<WorkerDocument> workerDocument;

}
