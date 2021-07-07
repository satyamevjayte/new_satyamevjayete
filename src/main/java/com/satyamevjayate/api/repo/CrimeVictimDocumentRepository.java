package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.CrimeVictimDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CrimeVictimDocumentRepository extends JpaRepository<CrimeVictimDocument, BigInteger> {
}
