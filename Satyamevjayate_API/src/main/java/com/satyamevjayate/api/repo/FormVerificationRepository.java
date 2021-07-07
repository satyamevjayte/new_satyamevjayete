package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.FormVerfication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface FormVerificationRepository extends JpaRepository<FormVerfication, BigInteger> {
}
