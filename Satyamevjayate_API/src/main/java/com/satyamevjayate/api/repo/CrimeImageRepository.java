package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.CrimeImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CrimeImageRepository extends JpaRepository<CrimeImage, BigInteger> {
}
