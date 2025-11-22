package com.phongtroapp.phongtro_backend.repository;

import com.phongtroapp.phongtro_backend.model.RentalRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RentalRoomRepository extends JpaRepository<RentalRoom,String> {
    List<RentalRoom> findByStatus(int status); // ds phong trong
}