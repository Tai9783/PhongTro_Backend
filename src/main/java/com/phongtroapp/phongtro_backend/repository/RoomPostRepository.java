package com.phongtroapp.phongtro_backend.repository;

import com.phongtroapp.phongtro_backend.model.RoomPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomPostRepository extends JpaRepository<RoomPost,String> {
    //--Các hàm có sẵn được Spring boot hỗ trợ và ko cần code
    // 1. save(entity): Lưu hoặc cập nhật
    // 2. findById(id): Tìm theo 1 ID
    // 3. findAllById(List<ID>): Tìm tất cả theo danh sách ID
}
