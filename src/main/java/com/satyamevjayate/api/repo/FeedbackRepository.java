package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface FeedbackRepository extends JpaRepository<Feedback, BigInteger> {
}
