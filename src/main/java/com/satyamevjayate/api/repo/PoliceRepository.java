package com.satyamevjayate.api.repo;

import java.math.BigInteger;
import java.util.List;

import com.satyamevjayate.api.model.CRimeTypewiseCrime;
import org.springframework.data.jpa.repository.JpaRepository;

import com.satyamevjayate.api.dto.PoliceRequest;
import com.satyamevjayate.api.entity.Police;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PoliceRepository extends JpaRepository<Police,Long> {
    @Query("SELECT r FROM Police r where r.policeContact.contactId = :Id")
    Police findIdByPwd(@Param("Id") Long Id);
    @Query("select new com.satyamevjayate.api.model.CRimeTypewiseCrime( count(*),pr.roleName)\n" +
            "from Police p,PoliceRole pr\n" +
            "where p.policeRoleID=pr.roleID\n" +
            "group by pr.roleName")
    public List<CRimeTypewiseCrime> findRolewisePoliceTotal();
    @Query("SELECT count(*) FROM Police")
    public Long findTotalPolice();
    @Transactional
   @Modifying
    @Query("update Police p set p.pwd= :newPwd where p.policeID= :Id")

    public void chnagePassword(@Param("Id") Long Id,@Param("newPwd") String newPwd);
}
