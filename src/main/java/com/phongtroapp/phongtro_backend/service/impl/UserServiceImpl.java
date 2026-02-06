package com.phongtroapp.phongtro_backend.service.impl;

import com.phongtroapp.phongtro_backend.model.User;
import com.phongtroapp.phongtro_backend.repository.impl.UserRepository;
import com.phongtroapp.phongtro_backend.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User getUser(String taikhoan, String pass) {
        User user= userRepository.findByEmailOrPhoneAndPass(taikhoan,pass);
        if (user !=null)
            return user;
        else
            return null;
    }

    @Override
    public User getUserById(String userId) {
        User user= userRepository.findByUserId(userId);
        if (user !=null)
            return user;
        else
            return null;
    }
}
