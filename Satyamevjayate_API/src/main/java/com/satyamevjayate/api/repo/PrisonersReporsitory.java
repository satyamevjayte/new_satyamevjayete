package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.Prisoners;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrisonersReporsitory extends JpaRepository<Prisoners,Long> {
}
