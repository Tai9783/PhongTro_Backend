package com.phongtroapp.phongtro_backend.repository;

import com.phongtroapp.phongtro_backend.model.RentalRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RentalRoomRepository extends JpaRepository<RentalRoom,String> {
    List<RentalRoom> findByStatus(int status); // ds phong trong

    @Query("SELECT r FROM RentalRoom r WHERE " +
            "r.price BETWEEN :minPrice AND :maxPrice " +
            "AND (:city IS NULL OR LOWER(r.city) LIKE LOWER(CONCAT('%', :city, '%')))")
    List<RentalRoom> filterRoomsPriceCity(Double minPrice, Double maxPrice, String city);//lấy phòng theo khoảng giá

    List<RentalRoom> findByPriceBetween(Double minPrice, Double maxPrice);//lấy phòng theo khoảng giá


}