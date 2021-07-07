package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.CrimeEvidence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrimeEvidenceRepository extends JpaRepository<CrimeEvidence,Long> {
}
