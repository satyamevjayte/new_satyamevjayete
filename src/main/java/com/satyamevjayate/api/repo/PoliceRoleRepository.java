package com.satyamevjayate.api.repo;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satyamevjayate.api.entity.PoliceRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PoliceRoleRepository extends JpaRepository<PoliceRole, Long> {
    @Query("SELECT r.roleID FROM PoliceRole r where r.roleName = :name")
   Long findIdByName(@Param("name") String name);
}
