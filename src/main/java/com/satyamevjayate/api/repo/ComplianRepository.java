package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.Complain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;

public interface ComplianRepository extends JpaRepository<Complain, Long> {

}
