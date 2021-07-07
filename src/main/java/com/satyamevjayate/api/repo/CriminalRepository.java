package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.Criminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CriminalRepository extends JpaRepository<Criminal,Long> {
    @Query("SELECT count(*) FROM Criminal")
    Long findTotalCriminal();
}
