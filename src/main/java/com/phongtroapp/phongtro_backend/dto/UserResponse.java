package com.phongtroapp.phongtro_backend.dto;

public record UserResponse(
        String userId,
        String fullName,
        String email,
        String role,
        String phone
) {}
