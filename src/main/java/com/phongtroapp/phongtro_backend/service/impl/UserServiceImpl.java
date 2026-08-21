package com.phongtroapp.phongtro_backend.service.impl;

import com.phongtroapp.phongtro_backend.dto.UserResponse;
import com.phongtroapp.phongtro_backend.model.User;
import com.phongtroapp.phongtro_backend.repository.UserRepository;
import com.phongtroapp.phongtro_backend.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserResponse getUser(String taikhoan, String pass) {
        User user = userRepository.findByEmailOrPhone(taikhoan);
        if (user == null || !passwordEncoder.matches(pass, user.getPass()))
            return null;
        return toResponse(user);
    }

    @Override
    public UserResponse getUserById(String userId) {
        User user = userRepository.findByUserId(userId);
        return user != null ? toResponse(user) : null;
    }

    private UserResponse toResponse(User user) {
        return new UserResponse(
                user.getUserId(),
                user.getFullName(),
                user.getEmail(),
                user.getRole(),
                user.getPhone()
        );
    }
}
