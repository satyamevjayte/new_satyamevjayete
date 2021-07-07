package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.Complain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ComplianRepository extends JpaRepository<Complain, Long> {
}
