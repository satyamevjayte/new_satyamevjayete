package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.CrimeSuspect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CrimeSuspectRepository extends JpaRepository<CrimeSuspect, BigInteger> {
}
