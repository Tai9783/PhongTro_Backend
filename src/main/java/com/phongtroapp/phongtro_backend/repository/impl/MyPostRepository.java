package com.phongtroapp.phongtro_backend.repository.impl;

import com.phongtroapp.phongtro_backend.dto.MyPost;
import com.phongtroapp.phongtro_backend.model.RentalRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MyPostRepository extends JpaRepository<RentalRoom,String> {
    @Query(value = "SELECT a.postId AS postId, a.roomId AS roomId, a.status AS status, " +
            "a.createdAt AS createAt, a.expired_at AS expireAt, " +
            "r.title AS title, r.price AS price, r.area AS area, " +
            "r.images_json AS imageJson " +
            "FROM rentalroom r JOIN advertisementpost a ON r.roomId = a.roomId " +
            "WHERE r.landlordId = :landlordId", nativeQuery = true)
    List<MyPost> getListPost(@Param("landlordId") String landlordId);
}
