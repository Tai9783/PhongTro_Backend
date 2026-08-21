package com.phongtroapp.phongtro_backend.service;

import com.phongtroapp.phongtro_backend.dto.UserResponse;

public interface UserService {
    UserResponse getUser(String taikhoan, String pass);

    UserResponse getUserById(String userId);
}
