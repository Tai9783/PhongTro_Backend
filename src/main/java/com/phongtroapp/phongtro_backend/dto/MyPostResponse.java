package com.phongtroapp.phongtro_backend.dto;

public record MyPostResponse(
        String postId,
        String roomId,
        boolean status,
        String createAt,
        String expireAt,
        String title,
        double price,
        double area,
        String imageJson
) {}
