package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Fid")
    private BigInteger Fid;

    @Column(name="Name")
    private String Name;

    @Column(name="Email")
    private String Email;

    @Column(name="Phone")
    private String Phone;

    @Column(name="Message")
    private String Message;


}
