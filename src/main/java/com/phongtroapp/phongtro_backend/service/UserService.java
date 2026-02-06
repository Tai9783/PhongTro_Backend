package com.phongtroapp.phongtro_backend.service;

import com.phongtroapp.phongtro_backend.model.User;

public interface UserService {
    User getUser(String taikhoan, String pass);

    User getUserById(String userId);
}
