package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.Crime;
import com.satyamevjayate.api.entity.Police;
import com.satyamevjayate.api.model.CRimeTypewiseCrime;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface CrimeRepository extends JpaRepository<Crime, BigInteger> {
    @Query("select new com.satyamevjayate.api.model.CRimeTypewiseCrime( count(*),ct.crimeType)\n" +
            "from Crime c,CrimeType ct\n" +
            "where c.crimeType=ct.crimeTypeId\n" +
            "group by ct.crimeType")
    public List<CRimeTypewiseCrime> findCrimeCrimeTypeWise();
    @Query("SELECT count(*) FROM Crime")
    Long findTotalCrime();
}

