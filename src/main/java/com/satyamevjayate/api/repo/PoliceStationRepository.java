package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.PoliceStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface PoliceStationRepository extends JpaRepository<PoliceStation, Long> {
}
