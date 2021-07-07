package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.Prison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PrisonRepository extends JpaRepository<Prison,Long> {
    @Query("SELECT count(*) FROM Prison")
    Long findTotalPrison();
}
