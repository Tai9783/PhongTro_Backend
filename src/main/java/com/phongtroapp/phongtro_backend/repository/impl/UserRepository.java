package com.phongtroapp.phongtro_backend.repository.impl;

import com.phongtroapp.phongtro_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User,String> {

    @Query("Select u from User u where (u.email= :input or u.phone= :input) and u.pass= :pass ")
    User findByEmailOrPhoneAndPass(@Param("input") String input,@Param("pass") String pass);

    User findByUserId(@Param("userId") String userId);
}
