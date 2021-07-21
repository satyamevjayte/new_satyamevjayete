package com.satyamevjayate.api.repo;
import com.satyamevjayate.api.entity.DAOUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserDao extends CrudRepository<DAOUser,Long> {
    DAOUser findByUsername(String username);
    @Modifying
    @Transactional
    @Query("update DAOUser d set d.password= :newPwd where d.username= :name")
    public void chnagePassword(@Param("name") String name, @Param("newPwd") String newPwd);
}