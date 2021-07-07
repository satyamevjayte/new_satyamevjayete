package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.Complainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplainerRepository extends JpaRepository<Complainer,Long> {
}
