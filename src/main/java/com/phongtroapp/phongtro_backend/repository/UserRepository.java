package com.phongtroapp.phongtro_backend.repository;

import com.phongtroapp.phongtro_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User,String> {

    @Query("Select u from User u where (u.email= :input or u.phone= :input)")
    User findByEmailOrPhone(@Param("input") String input);

    User findByUserId(@Param("userId") String userId);
}
