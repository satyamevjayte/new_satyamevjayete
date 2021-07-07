package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.CrimeSuspectDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CrimeSuspectDocumentRepository extends JpaRepository<CrimeSuspectDocument, BigInteger> {
}
