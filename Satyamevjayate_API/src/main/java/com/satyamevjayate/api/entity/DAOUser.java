package com.satyamevjayate.api.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class DAOUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userID;
    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;
}
