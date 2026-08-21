package com.phongtroapp.phongtro_backend.repository.impl;

import com.phongtroapp.phongtro_backend.model.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AmenityRepository extends JpaRepository<Amenity,String> {
    //--Các hàm có sẵn được Spring boot hỗ trợ và ko cần code
    // 1. save(entity): Lưu hoặc cập nhật
    // 2. findById(id): Tìm theo 1 ID
    // 3. findAllById(List<ID>): Tìm tất cả theo danh sách ID
}

