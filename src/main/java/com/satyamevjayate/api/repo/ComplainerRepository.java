package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.Complain;
import com.satyamevjayate.api.entity.Complainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ComplainerRepository extends JpaRepository<Complainer,Long> {
    @Query("select c from Complainer c where c.pwd=:name")
    Complainer findIdByPwd(@Param("name")String name);
}
