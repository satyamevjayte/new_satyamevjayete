package com.satyamevjayate.api.repo;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satyamevjayate.api.entity.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends JpaRepository<Contact,Long> {
    @Query("SELECT r.contactId FROM Contact r where r.contactEmail = :name")
    Long findIdByEmail(@Param("name") String name);
}
